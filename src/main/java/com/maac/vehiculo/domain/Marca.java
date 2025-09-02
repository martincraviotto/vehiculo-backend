package com.maac.vehiculo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Marca {

    @NonNull
    private Long id;

    @NonNull
    private String marca;
}
