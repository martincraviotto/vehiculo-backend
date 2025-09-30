package com.maac.vehiculo.mappers;


import com.maac.vehiculo.persistence.entities.MarcaEntity;
import org.mapstruct.Mapper;
import com.maac.vehiculo.domain.Marca;

@Mapper(componentModel = "spring")
public interface MarcasMapper {

    public Marca mapToMarca(MarcaEntity marcaEntity);

    public MarcaEntity mapToMarcaEntity(Marca marca);
}
