package com.maac.vehiculo.persistence.repositories;

import com.maac.vehiculo.persistence.entities.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity,Long> {
}
