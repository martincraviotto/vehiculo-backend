package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Lazy
// es es para definir que implementación utilizar en base a la configuracion en el archivo de propiedades
@ConditionalOnProperty(prefix = "implementacion", value = "marcas", havingValue = "motos")
@Service("motos")
public class MarcasMotosServiceImpl implements  MarcasService{


    ArrayList<Marca> marcas = new ArrayList<>();
/*
    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Yamaha"),
                    new Marca(2L,"Honda"),
                    new Marca(3L,"Siambreta"))
    );
*/
    public MarcasMotosServiceImpl() {
        log.info("Ejecutando constructor MarcasServiceImpl - motos");
    }

    public List<Marca> listAllMarcas(){
      return marcas;
    }

    @Override
    public Marca getMarcaById(Long id) {
        return null;
    }

    @Override
    public Marca addMarca(Marca marca) {

        return null;
    }

    @Override
    public List<Marca> addMarcas(List<Marca> marcas) {
        return marcas;
    }

    @Override
    public Marca updateMarca(Marca marca) {
        return null;
    }
}
