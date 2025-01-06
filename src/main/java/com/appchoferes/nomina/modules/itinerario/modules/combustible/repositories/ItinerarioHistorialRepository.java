package com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.ItinerariosHistorialDTO;

@Repository
public interface ItinerarioHistorialRepository extends CrudRepository<ItinerariosHistorialDTO,Long>{


    @Query(value = "CALL com_getItinerariosHistorial(:itinerarioId,:fechaActual);", nativeQuery = true)
    public void getItinerariosHistorial(int itinerarioId, String fechaActual);

}
