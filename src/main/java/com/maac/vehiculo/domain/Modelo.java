package com.maac.vehiculo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Modelo {

    @NonNull
    private Long id;

    @NonNull
    private String modelo;

    private String description;

}
