package nl.asrr.cosmos.app.config

import nl.asrr.common.id.IdGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AutoConfiguration {

    @Bean
    fun generator(): IdGenerator {
        return IdGenerator()
    }
}
