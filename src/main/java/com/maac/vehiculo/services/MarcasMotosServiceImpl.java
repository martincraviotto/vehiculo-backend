package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service("motos")
public class MarcasMotosServiceImpl implements  MarcasService{


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Yamaha"),
                    new Marca(2L,"Honda"),
                    new Marca(3L,"Siambreta"))
    );

    public List<Marca> listAllMarcas(){
      return marcas;
    }
}
