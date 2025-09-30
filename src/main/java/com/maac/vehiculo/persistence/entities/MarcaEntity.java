package com.maac.vehiculo.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "Marca")
@Data
@NoArgsConstructor
public class MarcaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;

        @NonNull
        @Column(name="marca", nullable = false)
        private String marca;

        @Column(name = "descripcion", nullable = true)
        private String descripcion;


}
