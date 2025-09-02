package com.maac.vehiculo.controllers;

import com.maac.vehiculo.domain.Marca;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
@Tag(name = "Api MicroService Vehiculo - Marcas", description = "CRUD  de Marcas de Vehículos")
public class MarcasRestController {


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Jeep"),
                    new Marca(2L,"Ford"),
                    new Marca(3L,"Fiat"))
    );


    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso encontrado")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta")
    @ApiResponse(responseCode = "404", description = "Recurso No Encontrado")
    @Operation(summary = "Recuperar una Marca por su Id", description = "Recupera una marca por su Id de tipo numérico. No puede ser un valor negativo. ")

    @GetMapping("/{id}")
    public ResponseEntity<?> getMarcaById(@Parameter(description = "Id de la marca - Valor entero", required = true, example = "1")
                                          @PathVariable Long id){

        if(id < 0){
            return ResponseEntity.badRequest().build();
        }

        for (Marca marca: this.marcas){
            if(marca.getId().equals(id))
                return  ResponseEntity.ok(marca);
        }
        return ResponseEntity.notFound().build();
    }



    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso encontrado")
    @Operation(summary = "Recupera todas las marcas de vehículos", description = "Recupera todas las marcas de vehiculos que se disponen. ")

    @GetMapping
    public ResponseEntity<?> listMarcas(){
        return ResponseEntity.ok(this.marcas);
    }


    @ApiResponse(responseCode = "201", description = "Operacion exitosa - Recurso dado de alta")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta")
    @Operation(summary = "Crea una nueva Marca de Vehiculo", description = "Crea una nueva marca de vehículo")

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

    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso actualizado")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta - Corroborar con el schema Marca")
    @ApiResponse(responseCode = "404", description = "Recurso No Encontrado")
    @Operation(summary = "Recuperar una Marca por su Id", description = "Recupera una marca por su Id de tipo numérico. No puede ser un valor negativo. ")

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
