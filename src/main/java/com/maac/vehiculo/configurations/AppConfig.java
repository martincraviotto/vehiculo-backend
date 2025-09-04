package com.maac.vehiculo.configurations;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@ConfigurationProperties(prefix = "app")
@Configuration
public class AppConfig {

    //Tiene que tener el mismo nombre que figura en el archivo de las propiedades
    private String nombre;
    private String descripcion;
    private String language;

    public AppConfig() {
      log.info("Construyendo AppConfig ");
    }
}
