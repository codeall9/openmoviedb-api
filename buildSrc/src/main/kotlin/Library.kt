object Library {
    private const val COLON = ":"
    private const val KOTLINX = "org.jetbrains.kotlinx$COLON"
    private const val KTOR = "io.ktor$COLON"

    object Coroutines {
        private const val VERSION = "$COLON${Version.COROUTINES}"
        const val CORE = "${KOTLINX}kotlinx-coroutines-core$VERSION"
        const val JDK8 = "${KOTLINX}kotlinx-coroutines-jdk8$VERSION"
        const val GUAVA = "${KOTLINX}kotlinx-coroutines-guava$VERSION"
        const val SLF4J = "${KOTLINX}kotlinx-coroutines-slf4j$VERSION"
        const val PLAY_SERVICES = "${KOTLINX}kotlinx-coroutines-play-services$VERSION"
        const val ANDROID = "${KOTLINX}kotlinx-coroutines-android$VERSION"
        const val test_jvm = "${KOTLINX}kotlinx-coroutines-test$VERSION"
    }

    object Serialization {
        private const val VERSION = "$COLON${Version.SERIALIZATION}"
        const val CORE = "${KOTLINX}kotlinx-serialization-core$VERSION"
        const val JSON = "${KOTLINX}kotlinx-serialization-json$VERSION"
        const val PROTOBUF = "${KOTLINX}kotlinx-serialization-protobuf$VERSION"
    }

    object Ktor {
        private const val VERSION = "$COLON${Version.KTOR}"
        const val COMMON = "${KTOR}ktor-client-core$VERSION"
        const val ANDROID = "${KTOR}ktor-client-android$VERSION"
        const val IOS = "${KTOR}ktor-client-ios$VERSION"
        const val JS = "${KTOR}ktor-client-js$VERSION"
        const val DESKTOPS = "${KTOR}ktor-client-curl$VERSION"
        const val JVM_APACHE = "${KTOR}ktor-client-apache$VERSION"
        const val JVM_COROUTINE = "${KTOR}ktor-client-cio$VERSION"
        const val JVM_JETTY = "${KTOR}ktor-client-jetty$VERSION"
        const val JVM_OKHTTP = "${KTOR}ktor-client-okhttp$VERSION"

        object Features {
            const val JSON = "${KTOR}ktor-client-json$VERSION"
            const val SERIALIZATION = "${KTOR}ktor-client-serialization$VERSION"
            const val LOGGING = "${KTOR}ktor-client-logging$VERSION"
            const val MOCK = "${KTOR}ktor-client-mock$VERSION"
        }
    }
}