object Library {
    private const val kotlinx = "org.jetbrains.kotlinx"

    object Coroutines {
        private const val version = Version.coroutines
        const val core = "$kotlinx:kotlinx-coroutines-core:$version"
        const val jdk8 = "$kotlinx:kotlinx-coroutines-jdk8:$version"
        const val guava = "$kotlinx:kotlinx-coroutines-guava:$version"
        const val slf4j = "$kotlinx:kotlinx-coroutines-slf4j:$version"
        const val play_services = "$kotlinx:kotlinx-coroutines-play-services:$version"
        const val android = "$kotlinx:kotlinx-coroutines-android:$version"
        const val test_jvm = "$kotlinx:kotlinx-coroutines-test:$version"
    }

    object Serialization {
        private const val version = Version.serialization
        const val core = "$kotlinx:kotlinx-serialization-core:$version"
        const val protobuf = "$kotlinx:kotlinx-serialization-protobuf:$version"
    }

    object Ktor {
        private const val groupId = "io.ktor"
        private const val version = Version.ktor
        const val common = "$groupId:ktor-client-core:$version"
        const val android = "$groupId:ktor-client-android:$version"
        const val ios = "$groupId:ktor-client-ios:$version"
        const val js = "$groupId:ktor-client-js:$version"
        const val desktops = "$groupId:ktor-client-curl:$version"
        const val jvm_apache = "$groupId:ktor-client-apache:$version"
        const val jvm_coroutine = "$groupId:ktor-client-cio:$version"
        const val jvm_jetty = "$groupId:ktor-client-jetty:$version"
        const val jvm_okhttp = "$groupId:ktor-client-okhttp:$version"

        object Features {
            const val json = "$groupId:ktor-client-json:$version"
            const val serialization = "$groupId:ktor-client-serialization:$version"
            const val logging = "$groupId:ktor-client-logging:$version"
            const val mock = "$groupId:ktor-client-mock:$version"
        }
    }
}