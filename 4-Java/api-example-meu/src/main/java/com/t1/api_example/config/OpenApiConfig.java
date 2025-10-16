package com.t1.api_example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Demonstration API",
        version = "v1",
        description = "API de demonstração com autenticação JWT e recursos de cursos e matrículas",
        contact = @Contact(
            name = "William José",
            email = "williamjmrosa@gmail.com",
            url = "https://github.com/williamjmrosa"
        )
    )
)
public class OpenApiConfig {

}
