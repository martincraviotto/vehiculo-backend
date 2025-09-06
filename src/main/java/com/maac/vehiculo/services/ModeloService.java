package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Modelo;

import java.util.Optional;

public interface ModeloService {

    public Optional<Modelo> getModeloById(Long id);


}
