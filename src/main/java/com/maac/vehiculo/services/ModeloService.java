package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Modelo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ModeloService {

    public Optional<Modelo> getModeloById(Long id);

    public List<Modelo> getAllModelos(Pageable pageable);


    public List<Modelo> getAllModelosWithIdLessThan(Long id);
}
