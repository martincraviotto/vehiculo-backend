package com.maac.vehiculo.configurations;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Data
@Configuration
@PropertySource(value = "classpath:parametros.properties")
@ConfigurationProperties(prefix = "parametro")
public class ParametrosConfig {

    //Tiene que tener el mismo nombre que figura en el archivo de las propiedades
    private String moneda;
    private String region;

    public ParametrosConfig() {

        log.info("Construyendo ParametrosConfig ");
    }
}
