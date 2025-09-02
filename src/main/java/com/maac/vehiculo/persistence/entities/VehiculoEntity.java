package com.maac.vehiculo.persistence.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VehiculoEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String marca;

    private String modelo;

    private String patente;

}
