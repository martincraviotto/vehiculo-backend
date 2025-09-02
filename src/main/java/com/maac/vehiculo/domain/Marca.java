package com.maac.vehiculo.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Schema(description = "Schema de una Marca de Vehiculo")
@Data
@AllArgsConstructor
public class Marca {

    @Schema(description = "Identificador de una marca", example = "1")
    @NonNull
    private Long id;


    @Schema(description = "Nombre de una marca", example = "Jeep")
    @NonNull
    private String marca;
}
