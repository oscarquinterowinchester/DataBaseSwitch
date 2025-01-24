package com.appchoferes.nomina.modules.itinerario.modules.fechas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO.FechaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.fechas.services.EventosItinerarioService;

@RestController
@RequestMapping("/api/drivermove/fecha")
@CrossOrigin(origins = "http://localhost:4200")
public class FechasController {

@Autowired
EventosItinerarioService eventosItinerarioService;

@GetMapping("/getEventos")
public ResponseEntity<?> getEventosByItinerarioId(@RequestParam int itinerarioId, @RequestParam String dbType){

    return ResponseEntity.ok(eventosItinerarioService.getEventosByItinerarioId(itinerarioId,dbType));
}

@PostMapping("/guardarFecha")
public ResponseEntity<?> guardarFecha(@RequestBody FechaDTO fechaDTO, @RequestParam String dbType){

    return ResponseEntity.ok(eventosItinerarioService.saveFechas(fechaDTO,dbType));
}











}
