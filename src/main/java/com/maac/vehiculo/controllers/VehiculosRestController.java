package com.maac.vehiculo.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculosRestController {

    @GetMapping("/vehiculos")
    public String vehiculos(){
        return "Listado de vehiculos";
    }

}
