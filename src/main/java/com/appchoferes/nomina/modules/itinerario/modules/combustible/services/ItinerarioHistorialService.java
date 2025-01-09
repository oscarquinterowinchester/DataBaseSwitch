package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.ItinerariosHistorialDTO;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.ItinerarioHistorialRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class ItinerarioHistorialService implements ItinerariosHistorialInterface {


    @Autowired
    ItinerarioHistorialRepository itinerarioHistorialRepository;

    @Autowired
    Utils utils;

    @Override
    public List<ItinerariosHistorialDTO> getItinerariosHistorial(int camionId, String fechaActual,String dbType) {

        utils.establecerBaseDatos(dbType);

       List<ItinerariosHistorialDTO> historial = itinerarioHistorialRepository.getItinerariosHistorial(camionId, fechaActual);

       return historial;
        
    }

}
