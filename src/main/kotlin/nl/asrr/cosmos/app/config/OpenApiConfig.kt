package nl.asrr.cosmos.app.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(
        @Value("\${spring.application.name}") appDesciption: String,
        @Value("\${spring.profiles.active}") profile: String,
        @Value("\${server.servlet.context-path}") contextPath: String
    ): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("ASRR $appDesciption API $profile")
                    .version("1.0.0")
                    .description(appDesciption)
                    .termsOfService("https://asrr.nl/assets/documents/algemene-voorwaarden-asrr.pdf")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(Contact().email("contact@asrr.nl").name("ASRR B.V.").url("https://asrr.nl"))
                    .description("This is the API documentation for my fantastic awesome incredible software.")
            )
    }
}
