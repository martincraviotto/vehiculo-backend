package com.maac.vehiculo.controllers;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maac.vehiculo.configurations.AppConfig;
import com.maac.vehiculo.configurations.ParametrosConfig;
import com.maac.vehiculo.domain.Marca;
import com.maac.vehiculo.services.MarcasService;
import com.maac.vehiculo.validators.groups.OnCreate;
import com.maac.vehiculo.validators.groups.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.InputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Tag(name = "Api MicroService Vehiculo - Marcas", description = "CRUD  de Marcas de Vehículos")
@Slf4j
@RestController
@RequestMapping("/marcas")
public class MarcasRestController {


    MarcasService marcasService;
    AppConfig appConfig;
    ParametrosConfig parametrosConfig;
    private final ObjectMapper objectMapper; //es la clase principal de Jackson, librería para serializar y deserializar JSON.

    public MarcasRestController(@Lazy MarcasService marcasService, AppConfig appConfig, ParametrosConfig parametrosConfig, ObjectMapper objectMapper) {
        log.info("Constructor MarcasRestController - AppConfig {} - Parametros : {} ", appConfig,parametrosConfig);
        this.marcasService = marcasService;
        this.objectMapper=objectMapper;
        this.appConfig=appConfig;
        this.parametrosConfig=parametrosConfig;
    }

    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso encontrado")
    @Operation(summary = "Recupera todas las marcas de vehículos", description = "Recupera todas las marcas de vehiculos que se disponen. ")
    @GetMapping
    public ResponseEntity<?> listMarcas(){
        List<Marca> marcas = marcasService.listAllMarcas();
        return ResponseEntity.ok(marcas);
    }

    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso encontrado")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta")
    @ApiResponse(responseCode = "404", description = "Recurso No Encontrado")
    @Operation(summary = "Recuperar una Marca por su Id", description = "Recupera una marca por su Id de tipo numérico. No puede ser un valor negativo. ")
    @GetMapping("/{id}")
    public ResponseEntity<?> getMarcaById(@Parameter(description = "Id de la marca - Valor entero", required = true, example = "1")
                                          @PathVariable Long id){
        if(id < 0)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(this.marcasService.getMarcaById(id));
    }

    @ApiResponse(responseCode = "201", description = "Operacion exitosa - Recurso dado de alta")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta")
    @Operation(summary = "Crea una nueva Marca de Vehiculo", description = "Crea una nueva marca de vehículo")
    @PostMapping
    public ResponseEntity<?> addMarca(@RequestBody  @Validated(OnCreate.class)  Marca marca){
        Marca marcaAdded = marcasService.addMarca(marca);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                //.path("/{id}")
                .path("/"+marcaAdded.getId())
                .buildAndExpand(marca.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/seeds")
    public ResponseEntity<?> seeds(){
        log.info("Creación masiva de  Marcas - seeds ");
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("./seeds/seedMarcas.json");
            if(is == null){
                log.error("No se ha podido leer el json: seedMarcas.json");
                return ResponseEntity.notFound().build();
            }
            List<Marca> marcas = Arrays.asList(objectMapper.readValue(is,Marca[].class));
            List<Marca> marcaList = marcasService.addMarcas(marcas);

            return ResponseEntity.ok(marcaList);
        } catch (StreamReadException e) {
            log.error("Error al intentar convertir en objetos del tipo Marca el json leido ", e);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Error al intentar convertir en objetos del tipo Marca el json leido");
        } catch (Exception e) {
            log.error("Error inesperado al cargar seeds", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }

    }


    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso actualizado")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta - Corroborar con el schema Marca")
    @ApiResponse(responseCode = "404", description = "Recurso No Encontrado")
    @Operation(summary = "Actualiza una Marca por su Id", description = "Recupera una marca por su Id de tipo numérico. No puede ser un valor negativo. ")

    @PutMapping
    public ResponseEntity<?> updateMarca(@RequestBody  @Validated(OnUpdate.class)  Marca marca){

        if(marca.getId() <= 0)
            return ResponseEntity.badRequest().build();
        else {

             return ResponseEntity.ok(this.marcasService.updateMarca(marca));
            /*
            Optional<Marca> marcaOptional = this.marcasService.updateMarca(marca);
            if (marcaOptional.isPresent())
                return ResponseEntity.ok(marcaOptional.get());
            else
                return ResponseEntity.notFound().build();

             */
        }

    }

/*
    @ApiResponse(responseCode = "200", description = "Operacion exitosa - Recurso eliminado")
    @ApiResponse(responseCode = "400", description = "Petición Incorrecta - Corroborar con el schema Marca")
    @ApiResponse(responseCode = "404", description = "Recurso No Encontrado")
    @Operation(summary = "Elimina una Marca por su Id", description = "Elimina una marca por su Id de tipo numérico. No puede ser un valor negativo. ")

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarca(@PathVariable Long id){

        if(id < 0){
            return ResponseEntity.badRequest().build();
        }

        //todo implementar baja de una marca.
        for (Marca marca: this.marcas){
            if(marca.getId().equals(id)) {
                this.marcas.remove(marca);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Modifica solo un atributo del recurso
    @PatchMapping("/{id}")
    public ResponseEntity<?> modificarAtributo(@PathVariable Long id,String attributeName, String newValue){
        for (Marca m1: this.marcas){
            if(m1.getId().equals(id)) {
                if(attributeName.equalsIgnoreCase("marca")){
                    m1.setMarca(newValue);
                }
                return ResponseEntity.ok(m1);
            }
        }
        return ResponseEntity.notFound().build();
    }



     */
}
