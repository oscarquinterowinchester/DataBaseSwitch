package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.ContenedorItinerario;

@Repository
public interface IContenedorItinerarioRepository extends CrudRepository<ContenedorItinerario, Long>{

    @Query(value = "CALL DM_getContenedorInfoIti(:itinerarioId);", nativeQuery = true)
    public List<ContenedorItinerario> getContenedorIti(String itinerarioId);


}
