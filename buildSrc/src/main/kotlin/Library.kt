object Library {
    private const val kotlinx = "org.jetbrains.kotlinx"

    object Coroutines {
        private const val version = Version.coroutines
        const val core_common = "$kotlinx:kotlinx-coroutines-core-common:$version"
        const val core_jvm = "$kotlinx:kotlinx-coroutines-core:$version"
        const val core_js = "$kotlinx:kotlinx-coroutines-core-js:$version"
        const val core_native = "$kotlinx:kotlinx-coroutines-core-native:$version"
        const val android = "$kotlinx:kotlinx-coroutines-android:$version"
    }

    object Serialization {
        private const val version = Version.serialization
        const val runtime_common = "$kotlinx:kotlinx-serialization-runtime-common:$version"
        const val runtime_jvm = "$kotlinx:kotlinx-serialization-runtime:$version"
        const val runtime_js = "$kotlinx:kotlinx-serialization-runtime-js:$version"
        const val runtime_native = "$kotlinx:kotlinx-serialization-runtime-native:$version"
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

        object Core {
            const val jvm = "$groupId:ktor-client-core-jvm:$version"
            const val js = "$groupId:ktor-client-core-js:$version"
            const val native = "$groupId:ktor-client-core-native:$version"
            @Deprecated("The ktor-*-ios artifacts is now ktor-*-native", ReplaceWith("native"))
            const val ios = "$groupId:ktor-client-core-ios:$version"
        }

        object Json {
            const val common = "$groupId:ktor-client-json:$version"
            const val jvm = "$groupId:ktor-client-json-jvm:$version"
            const val js = "$groupId:ktor-client-json-js:$version"
            const val native = "$groupId:ktor-client-json-native:$version"
        }

        object Serialization {
            const val common = "$groupId:ktor-client-serialization:$version"
            const val jvm = "$groupId:ktor-client-serialization-jvm:$version"
            const val js = "$groupId:ktor-client-serialization-js:$version"
            const val native = "$groupId:ktor-client-serialization-native:$version"
        }

        object Logging {
            const val common = "$groupId:ktor-client-logging:$version"
            const val jvm = "$groupId:ktor-client-logging-jvm:$version"
            const val js = "$groupId:ktor-client-logging-js:$version"
            const val native = "$groupId:ktor-client-logging-native:$version"
        }

        object Mock {
            const val common = "$groupId:ktor-client-mock:$version"
            const val jvm = "$groupId:ktor-client-mock-jvm:$version"
            const val js = "$groupId:ktor-client-mock-js:$version"
            const val native = "$groupId:ktor-client-mock-native:$version"
        }
    }
}