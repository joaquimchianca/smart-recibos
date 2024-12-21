package br.ufrn.SmartRecibos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration

public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Smart-Recibos API")
                .description("API com os Endpoints do Sistema Smart-Recibos")
                .version("0.0.1")
                .contact(new Contact().name("Equipe Smart-Recibos")
                        .email("joaquimchianca@gmail.com")));
    }
}