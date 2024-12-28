package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.VentanaHistorialCarga;

@Service
public interface IVentanaHistorialCargaService {

    public VentanaHistorialCarga getVentanaHistorialCarga(Long unidadId,int tipoUnidad,String dbType);

}
