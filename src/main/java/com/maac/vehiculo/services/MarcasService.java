package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcasService {


    public List<Marca> listAllMarcas();

    public Marca getMarcaById(Long id);

    public Marca addMarca(Marca marca);

    public List<Marca> addMarcas(List<Marca> marcas);

    public Marca updateMarca(Marca marca);
}
