package com.appchoferes.nomina.modules.itinerario.modules.combustible.controllers;


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

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.ItinerariosHistorialDTO;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.VentanaHistorialCarga;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.models.CargasDieselEntity;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.services.ICargaDieselService;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.services.ItinerariosHistorialInterface;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.services.VentanaHistorialCargaService;

@RestController
@RequestMapping("/api/drivermove/combustible")
@CrossOrigin(origins = "http://localhost:4200")  
public class CargaCombustibleController {

    @Autowired
    VentanaHistorialCargaService ventanaInformacionService;

    @Autowired
    ICargaDieselService cargaDieselService;

    @Autowired
    ItinerariosHistorialInterface historialItiservice;

    @GetMapping("/historial")
    private ResponseEntity<?> getVentanaHistorialCargas(@RequestParam Long itinerarioId,
     @RequestParam String dbType ){ 

        VentanaHistorialCarga ventanaHistorial  = ventanaInformacionService.getVentanaHistorialCarga(itinerarioId,dbType);

        return ResponseEntity.ok(ventanaHistorial);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> insertarCarga(@RequestBody CargasDieselEntity entity,String dbType) {

        return cargaDieselService.procesarCarga(entity, dbType);
        
    }

    @GetMapping("/historialItinerarios")
    public ResponseEntity<?> getItinerariosHistorial(@RequestParam int camionId,
    @RequestParam  String fechaActual,@RequestParam String dbType) {

        List<ItinerariosHistorialDTO> historial = historialItiservice.getItinerariosHistorial(camionId, fechaActual, dbType);

        return ResponseEntity.ok(historial);
        
    }

    // @PatchMapping("/cargas/{cargaId}")
    // public ResponseEntity<String> actualizarCargaPorCampos(@PathVariable String cargaId,@RequestBody Map<String,Object> campos,@RequestParam String dbType) {
    //     ResponseEntity<String> mensaje = cargasDieselService.actualizarCargaPorCampos(cargaId,campos,dbType);
    //     return mensaje;
    // }

    // @PostMapping("/guardar")
    // @ResponseStatus(HttpStatus.CREATED)
    // private void saveCargaDiesel(@RequestBody CargaDiesel cargaDiesel,@RequestParam String dbType){

    //     cargaDieselService.guardarCargaDiesel(cargaDiesel,dbType);

    // }



}
