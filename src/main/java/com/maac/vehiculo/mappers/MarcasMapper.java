package com.maac.vehiculo.mappers;

import com.maac.vehiculo.domain.Marca;
import com.maac.vehiculo.persistence.entities.MarcaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  MarcasMapper {

    public Marca mapToMarca(MarcaEntity marcaEntity);

    public MarcaEntity mapToMarcaEntity(Marca marca);

}
