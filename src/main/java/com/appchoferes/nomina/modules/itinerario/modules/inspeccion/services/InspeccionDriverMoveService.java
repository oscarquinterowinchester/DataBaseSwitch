package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.models.InspeccionDriverMoveEntity;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.repository.InspeccionDriveMoveRepository;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.requests.DTO.InspeccionDriverMoveDTO;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class InspeccionDriverMoveService {


    @Autowired
    InspeccionDriveMoveRepository inspeccionDriveMoveRepository;

    @Autowired
    Utils utils;

    public ResponseEntity<?> setInspeccion(InspeccionDriverMoveDTO puntoMarcado, String dbType){

        utils.establecerBaseDatos(dbType);
        
        InspeccionDriverMoveEntity puntoInspeccion = null;

        try{

            if(puntoMarcado.getInspeccionId() == null || puntoMarcado.getItinerarioId() == 0){

                throw new IllegalArgumentException("punto Inspeccion invalido");
            }
         
            puntoInspeccion = inspeccionDriveMoveRepository.getInspeccionDriverMoveEntityByInspeccionId(puntoMarcado.getInspeccionId());
            
            puntoInspeccion.setBien(puntoMarcado.isBien());
    
            inspeccionDriveMoveRepository.save(puntoInspeccion);

        }catch(NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }
       

        return ResponseEntity.ok(puntoInspeccion);
    }

}
