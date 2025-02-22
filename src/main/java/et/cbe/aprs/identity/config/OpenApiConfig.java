package et.cbe.aprs.identity.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Performance Trend Analysis Service API")
                        .description("API documentation for PTA")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("CBE Contact")
                                .email("info@cbe.com.et")
                                .url("https://combanketh.com.et"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}