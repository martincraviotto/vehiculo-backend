package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("autos")
public class MarcasServiceImpl implements  MarcasService{


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Citroen"),
                    new Marca(2L,"Ford"),
                    new Marca(3L,"Ram"))
    );

    public List<Marca> listAllMarcas(){
      return marcas;
    }
}
