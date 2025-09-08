package com.maac.vehiculo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name="Modelo")
@Data
@NoArgsConstructor
public class ModeloEntity {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "model")
    @NonNull
    private String modelo;

    private String description;

}
