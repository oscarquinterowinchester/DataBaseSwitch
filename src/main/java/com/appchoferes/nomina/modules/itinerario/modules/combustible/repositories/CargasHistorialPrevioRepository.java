package com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.CargasHistorialPrevio;

@Repository
public interface CargasHistorialPrevioRepository extends CrudRepository<CargasHistorialPrevio,Long>{

    @Query(value = "call com_getCombustibleHistorial(:id, :tipo)", nativeQuery = true)
    List<CargasHistorialPrevio> getHistorialCargas(Long id, Integer tipo);


}
