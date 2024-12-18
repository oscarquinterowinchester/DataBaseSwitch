package com.appchoferes.nomina.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.Semana;

@Repository
public interface ISemanaRepository extends CrudRepository<Semana,Long>{
    @Query(value = "CALL getFechasSemana(:semanaId);", nativeQuery = true)
    public Semana getSemanas(String semanaId);

}
