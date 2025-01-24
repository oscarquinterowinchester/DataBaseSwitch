package com.appchoferes.nomina.modules.itinerario.modules.extra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.modules.extra.DTO.ExtraRequestDTO;
import com.appchoferes.nomina.modules.itinerario.modules.extra.services.CajaChicaService;

@RestController
@RequestMapping("/api/drivermove/extra")
@CrossOrigin(origins = "http://localhost:4200")  
public class ExtraController {

    @Autowired
    CajaChicaService cajaChicaService;


    @PostMapping("/guardarExtra")
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.POST})
    public ResponseEntity<?> guardarExtra(@RequestBody ExtraRequestDTO extra, @RequestParam String dbType)
    {

        return ResponseEntity.ok(cajaChicaService.guardarCajaChica(extra, dbType));
    }

    @GetMapping("/eliminarExtra")
    public ResponseEntity<?> eliminarExtra(@RequestParam(name = "id") int cajaId, @RequestParam String dbType)
    {

        return ResponseEntity.ok(cajaChicaService.eliminarCajaChica(cajaId, dbType));
    }

    @GetMapping("/getExtras")
    public ResponseEntity<?> getExtras(@RequestParam(name = "id") int itinerarioId, @RequestParam String dbType)
    {

        return ResponseEntity.ok(cajaChicaService.getExtrasByItinerarioId(itinerarioId, dbType));
    }

    @GetMapping("/getConceptos")
    public ResponseEntity<?> getConceptos(@RequestParam String dbType)
    {

        return ResponseEntity.ok(cajaChicaService.getConceptos(dbType));
    }



}
