package com.appchoferes.nomina.modules.itinerario.modules.fechas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO.EventosItinerarioDTO;

@Repository
public interface EventosItinerarioRepository extends CrudRepository<EventosItinerarioDTO,Long>{

    @Query(value = "CALL FECHAS_getEventosByItinerarioId(:itinerarioId);",nativeQuery = true)
    public List<EventosItinerarioDTO> getEventosByItinerarioId(int itinerarioId);

    @Query(value = "SELECT FECHA_getRevisionMecanica(:itinerarioId);",nativeQuery = true)
    public boolean getRevisionMecanica(int itinerarioId);

}
