package com.maac.vehiculo.persistence.repositories;

import com.maac.vehiculo.domain.Modelo;
import com.maac.vehiculo.persistence.entities.ModeloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<ModeloEntity,Long> {

    //MAS INFO SOBRE ESTE TEMA EN : https://www.baeldung.com/spring-jpa-like-queries

    public List<ModeloEntity> findByIdLessThan(Long id);


}
