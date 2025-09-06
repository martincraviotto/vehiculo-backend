package com.maac.vehiculo.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Modelo {

    @NonNull
    private Long id;

    @NonNull
    private String modelo;

    private String description;

}
