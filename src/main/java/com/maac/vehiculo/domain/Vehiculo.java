package com.maac.vehiculo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Vehiculo {

    @NonNull
    private long id;

    private String marca;

    private String modelo;

    private String patente;
}
