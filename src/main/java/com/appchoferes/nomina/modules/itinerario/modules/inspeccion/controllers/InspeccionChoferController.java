package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.DTO.ListaInspeccionChoferDTO;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.requests.DTO.InspeccionDriverMoveDTO;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.services.InspeccionDriverMoveService;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.services.ListaInspeccionChoferService;

@RestController
@RequestMapping("/api/drivermove/inspeccion")
@CrossOrigin(origins = "http://localhost:4200")  
public class InspeccionChoferController {

    @Autowired
    ListaInspeccionChoferService listadoService;

    @Autowired
    InspeccionDriverMoveService inspeccionDriverMoveService;

    @GetMapping("/listado")
    public ResponseEntity<?> getListadoByItinerarioId(@RequestParam int itinerarioId, @RequestParam String dbType){

        List<ListaInspeccionChoferDTO>  listado = listadoService.getListaInspeccionByItinerario(itinerarioId, dbType);
    
        return ResponseEntity.ok(listado);
    }

    @PostMapping("/setInspeccion")
    public ResponseEntity<?> setInspeccion(@RequestBody InspeccionDriverMoveDTO puntoMarcado,
     @RequestParam String dbType){

        return inspeccionDriverMoveService.setInspeccion(puntoMarcado, dbType);
    }


}
