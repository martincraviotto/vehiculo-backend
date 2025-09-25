package com.maac.vehiculo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity(name = "Marca")
@Data
@NoArgsConstructor
public class MarcaEntity {

    //@NonNull //lombok
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(name="marca", nullable = false)
    private String marca;

    @Column(name = "descripcion")
    private String descripcion;
}
