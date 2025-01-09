package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.ItinerariosHistorialDTO;

@Service
public interface ItinerariosHistorialInterface {

    public List<ItinerariosHistorialDTO>  getItinerariosHistorial(int camionId, String fechaActual,String dbType);

}
