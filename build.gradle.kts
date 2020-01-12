plugins {
    kotlin("multiplatform") version Version.kotlin
    kotlin("plugin.serialization") version Version.kotlin
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
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    jvm()
    js {
        /*browser {
        }
        nodejs {
        }*/
    }
    // For ARM, should be changed to iosArm32 or iosArm64
    // For Linux, should be changed to e.g. linuxX64
    // For MacOS, should be changed to e.g. macosX64
    // For Windows, should be changed to e.g. mingwX64
//    mingwX64("mingw")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Library.Serialization.runtime_common)
                implementation(Library.Ktor.common)
                implementation(Library.Ktor.Json.common)
                implementation(Library.Ktor.Serialization.common)
                implementation(Library.Ktor.Logging.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                api(Library.Ktor.Mock.common)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(Library.Serialization.runtime_jvm)
                implementation(Library.Ktor.Core.jvm)
                implementation(Library.Ktor.Json.jvm)
                implementation(Library.Ktor.Serialization.jvm)
                implementation(Library.Ktor.Logging.jvm)
                implementation("ch.qos.logback:logback-classic:1.2.3")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))

                api(Library.Ktor.Mock.jvm)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
//                implementation(Library.Coroutines.core_js)
                implementation(Library.Serialization.runtime_js)
                implementation(Library.Ktor.Core.js)
                implementation(Library.Ktor.Json.js)
                implementation(Library.Ktor.Serialization.js)
                implementation(Library.Ktor.Logging.js)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))

                api(Library.Ktor.Mock.js)
//                api(npm("text-encoding"))
            }
        }

        // Note that the Kotlin metadata is here, too.
        // The mingwx64()/iosArm64() target is automatically skipped as incompatible in Linux builds.
        configure(listOf(metadata(), jvm(), js())) {
            mavenPublication {
                val targetPublication = this@mavenPublication
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .all { onlyIf { findProperty("isLinux") == "true" } }
//                    .all { onlyIf { findProperty("isWindows") == "true" } }
//                    .all { onlyIf { findProperty("isMacOsX") == "true" } }
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
    publications {
        val jvm by getting { /* Setup the publication for target 'jvm' */ }
        val js by getting { /* Setup the publication for target 'js' */ }
        val metadata by getting { /* Setup the publication for Kotlin metadata */ }
    }
}
/*tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
    .configureEach {
        kotlinOptions { freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental") }
    }*/
