package com.maac.vehiculo.controllers;



import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.exceptions.ModeloNotFoundException;
import com.maac.vehiculo.services.ModeloService;
import com.maac.vehiculo.validators.groups.OnCreate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Api MicroService Vehiculo - Modelos", description = "CRUD  de Modelos de una Marca de Vehículos")
@Slf4j
@RestController
@RequestMapping("/modelos")
public class ModelosRestController {


        private ModeloService modeloService;

        public ModelosRestController(ModeloService modeloService) {
                this.modeloService = modeloService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getModeloById(@PathVariable Long id){
                return this.modeloService.getModeloById(id)
                        .map(modelo -> ResponseEntity.ok(modelo))
                        .orElseThrow(ModeloNotFoundException::new);
        }

        @GetMapping
        public ResponseEntity<?> getAllModelos(
                @PageableDefault(size = 2,sort={"modelo", "id"}, direction = Sort.Direction.ASC)
                Pageable pageable){
                return ResponseEntity.ok(this.modeloService.getAllModelos(pageable));
        }

        @GetMapping("/idLessThan/{id}")
        public ResponseEntity<?> getAllModelosWithIdLessThan(@PathVariable Long id){
                return ResponseEntity.ok(this.modeloService.getAllModelosWithIdLessThan(id));
        }

        @PostMapping
        public ResponseEntity<?> createMarca(@RequestBody  @Validated(OnCreate.class) Modelo modelo){

                return ResponseEntity.notFound().build();
        }


}
