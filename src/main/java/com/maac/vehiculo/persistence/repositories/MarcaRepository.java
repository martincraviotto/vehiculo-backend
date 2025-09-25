package com.maac.vehiculo.persistence.repositories;


import com.maac.vehiculo.persistence.entities.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity,Long> {

}
