package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.persistence.repositories.ModeloRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloServiceImpl implements  ModeloService{

    ModeloRepository modeloRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public Optional<Modelo> getModeloById(Long id){
        return this.modeloRepository.findById(id)
                .map(modeloEntity -> {
                    Modelo modelo = new Modelo(modeloEntity.getId(), modeloEntity.getModelo(), modeloEntity.getDescription());
                    return modelo;
                });

    }

    @Override
    public List<Modelo> getAllModelos(Pageable pageable) {
        return this.modeloRepository.findAll(pageable)
                .stream().map(modeloEntity -> {
                    Modelo modelo = new Modelo(modeloEntity.getId(), modeloEntity.getModelo(), modeloEntity.getDescription());
                    return modelo;
                })
                .collect(Collectors.toList());
    }
}
