package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcasService {


    public List<Marca> listAllMarcas();

    public Optional<Marca> getMarcaById(Long id);

    public Optional<Marca> addMarca(Marca marca);

    public Optional<List<Marca>> addMarcas(List<Marca> marcas);
}
