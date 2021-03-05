package nl.asrr.cosmos.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Log {
    companion object {
        inline var <reified T> T.logger: Logger
            get() = LoggerFactory.getLogger(T::class.java)
            set(value) {}
    }
}