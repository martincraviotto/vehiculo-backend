package com.maac.vehiculo.domain;

import com.maac.vehiculo.validators.groups.OnCreate;
import com.maac.vehiculo.validators.groups.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Schema(description = "Schema de un Modelo de un Vehiculo")
@Data
@AllArgsConstructor
public class Modelo {

    @NonNull
    @Schema(description = "Identificador de un modelo de una marca de un vehículo", example = "1")
    private Long id;

    @NonNull
    @NotBlank(groups = {OnUpdate.class, OnCreate.class}) //Java Validation
    @Schema(description = "Nombre del modelo de una marca de un vehiculo", example = "Sport")
    private String modelo;

    @Schema(description = "Descripcion del modelo de una marca de un vehículo", example = "Modelo Base de la marca")
    private String description;

}
