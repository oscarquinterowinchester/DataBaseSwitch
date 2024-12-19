package com.appchoferes.nomina.modules.nomina.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.nomina.dto.SemanaDTO;

@Repository
public interface SemanaRepository extends CrudRepository<SemanaDTO,Long>{

    @Query(value = "CALL getFechasSemana(:semanaId);", nativeQuery = true)
    public SemanaDTO getSemanas(String semanaId);

}
