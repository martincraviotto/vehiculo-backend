package com.maac.vehiculo.mappers;

import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.persistence.entities.ModeloEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelosMapper {

    public Modelo mapToModelo (ModeloEntity modeloEntity);

    public ModeloEntity mapToModeloEntity (Modelo modelo);
}
