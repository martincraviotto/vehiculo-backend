package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Modelo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ModeloServiceImpl implements  ModeloService{

    public Optional<Modelo> getModeloById(Long id){
        if (id > 0) {
            Modelo modelo =  new Modelo(1L, "Sport");
            return Optional.of(modelo);

        }
        return Optional.empty();
    }
}
