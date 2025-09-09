package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.mappers.ModelosMapper;
import com.maac.vehiculo.persistence.repositories.ModeloRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloServiceImpl implements  ModeloService{

    ModeloRepository modeloRepository;
    ModelosMapper modelosMapper;

    public ModeloServiceImpl(ModeloRepository modeloRepository, ModelosMapper modelosMapper) {
        this.modeloRepository = modeloRepository;
        this.modelosMapper = modelosMapper;
    }

    public Optional<Modelo> getModeloById(Long id){
        return this.modeloRepository.findById(id)
                .map(modelosMapper::mapToModelo);

    }

    @Override
    public List<Modelo> getAllModelos(Pageable pageable) {
        return this.modeloRepository.findAll(pageable)
                .stream().map(modelosMapper::mapToModelo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Modelo> getAllModelosWithIdLessThan(Long id) {
        return null;
    }
}
