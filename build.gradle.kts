plugins {
    kotlin("multiplatform") version Version.KOTLIN
    kotlin("plugin.serialization") version Version.KOTLIN
    id("maven-publish")
}

repositories {
    mavenLocal()
    maven(url = "https://dl.bintray.com/kotlin/ktor")
    maven(url = "https://dl.bintray.com/kotlin/kotlinx")
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
    mavenCentral()
    jcenter()
}

group = "io.codeall9.film"
version = "1.0.0-SNAPSHOT"

kotlin {
    /* Targets configuration omitted.
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/mpp-intro.html */
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js(IR) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(Library.Serialization.JSON)
                implementation(Library.Ktor.COMMON)
                implementation(Library.Ktor.Features.JSON)
                implementation(Library.Ktor.Features.SERIALIZATION)
                implementation(Library.Ktor.Features.LOGGING)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                api(Library.Ktor.Features.MOCK)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("ch.qos.logback:logback-classic:1.2.3")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))

                api(Library.Coroutines.test_jvm)
            }
        }

        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val nativeMain by getting
        val nativeTest by getting

        // Note that the Kotlin metadata is here, too.
        configure(listOf(targets["metadata"], jvm(), js())) {
            mavenPublication {
                val targetPublication = this@mavenPublication
                tasks.withType<AbstractPublishToMaven>()
                        .matching { it.publication == targetPublication }
                        .all { onlyIf { findProperty("isMainHost") == "true" } }
                // The mingwx64()/iosArm64() target is automatically skipped as incompatible in Linux builds.
//                        .all { onlyIf { findProperty("isLinux") == "true" } }
            }
        }
    }
}

publishing {
    repositories {
        maven {
            val user = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            val key = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/$user/openmoviedb-api")
            credentials {
                username = user
                password = key
            }
        }
    }
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.ALL
}