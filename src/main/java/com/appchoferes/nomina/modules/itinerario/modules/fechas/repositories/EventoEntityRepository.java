package com.appchoferes.nomina.modules.itinerario.modules.fechas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.fechas.models.EventosEntity;

@Repository
public interface EventoEntityRepository extends CrudRepository<EventosEntity,Long>{


    public EventosEntity findEventosEntityByEventoWCId(Long eventoWCId);


}
