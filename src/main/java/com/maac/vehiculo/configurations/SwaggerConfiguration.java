package com.maac.vehiculo.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Vehiculo Api",
                description = "Vehiculos Microservice",
                contact = @Contact(
                        name = "Martin Craviotto",
                        url = "http:\\google.com",
                        email = "martincraviotto@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "http://github.com/thombergs/code-examples/blob/master/LICENSE"
                )
        ),
        servers = @Server(
                url = "http://localhost:8080/maac/api/v1/endpoints"
        )
)

public class SwaggerConfiguration {
}