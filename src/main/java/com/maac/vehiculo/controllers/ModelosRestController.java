package com.maac.vehiculo.controllers;


import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.exceptions.ModeloNotFoundException;
import com.maac.vehiculo.services.ModeloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


}
