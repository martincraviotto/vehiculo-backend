package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@ConditionalOnProperty(prefix = "implementacion", value = "marcas", havingValue = "motos")
@Lazy
@Service("motos")
public class MarcasMotosServiceImpl implements  MarcasService{


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Yamaha"),
                    new Marca(2L,"Honda"),
                    new Marca(3L,"Siambreta"))
    );

    public MarcasMotosServiceImpl() {
        log.info("Ejecutando constructor MarcasServiceImpl - motos");
    }

    public List<Marca> listAllMarcas(){
      return marcas;
    }
}
