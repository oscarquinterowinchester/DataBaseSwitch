package com.appchoferes.nomina.modules.itinerario.modules.fechas.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO.EventosItinerarioDTO;
import com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO.FechaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.fechas.models.EventosEntity;
import com.appchoferes.nomina.modules.itinerario.modules.fechas.repositories.EventoEntityRepository;
import com.appchoferes.nomina.modules.itinerario.modules.fechas.repositories.EventosItinerarioRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class EventosItinerarioService {

    @Autowired
    EventosItinerarioRepository eventosItinerarioRepository;

    @Autowired
    Utils utils;

    @Autowired
    EventoEntityRepository eventoEntityRepository;

    public Map<String,Object> getEventosByItinerarioId(int itinerarioId, String dbType){

        utils.establecerBaseDatos(dbType);

        Map<String,Object> eventosItinerario = new HashMap<>();

        eventosItinerario.put("fechas", eventosItinerarioRepository.getEventosByItinerarioId(itinerarioId));

        eventosItinerario.put("revision", eventosItinerarioRepository.getRevisionMecanica(itinerarioId));
        eventosItinerario.put("validado", true);

       return eventosItinerario;
    }


    public EventosEntity saveFechas(FechaDTO fechasDTO,String dbType){

        utils.establecerBaseDatos(dbType);

        Long eventoWCId = Long.valueOf(fechasDTO.getEventoWCID());

        System.out.println(fechasDTO.toString());

        EventosEntity eventosEntity =  eventoEntityRepository.findEventosEntityByEventoWCId(eventoWCId);

        eventosEntity.setFechaEvento(fechasDTO.getFechaEvento());
        eventosEntity.setFecha(fechasDTO.getFecha());

        eventoEntityRepository.save(eventosEntity);

        return eventosEntity;
    }

}
