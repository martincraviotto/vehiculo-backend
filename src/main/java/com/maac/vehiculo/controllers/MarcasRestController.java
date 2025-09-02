package com.maac.vehiculo.controllers;

import com.maac.vehiculo.domain.Marca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcasRestController {


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Jeep"),
                    new Marca(2L,"Ford"),
                    new Marca(3L,"Fiat"))
    );


    @GetMapping("/{id}")
    public ResponseEntity<?> getMarcaById(@PathVariable Long id){
        //return marcas.stream().filter(marca -> marca.getId() == id).;

        if(id < 0){
            return ResponseEntity.badRequest().build();
        }

        for (Marca marca: this.marcas){
            if(marca.getId().equals(id))
                return  ResponseEntity.ok(marca);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> listMarcas(){
        return ResponseEntity.ok(this.marcas);
    }

    @PostMapping
    public ResponseEntity<?> createMarca(@RequestBody  Marca marca){
        this.marcas.add(marca);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(marca.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping
    public ResponseEntity<?> updateMarca(@RequestBody  Marca marca){
        for (Marca m1: this.marcas){
            if(m1.getId().equals(marca.getId())) {
                m1.setMarca(marca.getMarca());
                return ResponseEntity.ok(marca);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarca(@PathVariable Long id){
        //todo implementar baja de una marca.
        for (Marca marca: this.marcas){
            if(marca.getId().equals(id)) {
                this.marcas.remove(marca);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
