package com.maac.vehiculo.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Schema(description = "Schema de una Marca de Vehiculo")
@Data
@AllArgsConstructor
public class Marca {

    @NonNull
    @Schema(description = "Identificador de una marca", example = "1")
    private Long id;


    @NonNull
    @Schema(description = "Nombre de una marca", example = "Jeep")
    private String marca;
}
