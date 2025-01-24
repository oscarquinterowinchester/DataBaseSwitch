package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.RevisionDTO;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.services.RevisionMecanicaService;

@RestController
@RequestMapping("/api/drivermove/revision")
@CrossOrigin(origins = "http://localhost:4200")  

public class RevisionMecanicaController {


    @Autowired
    RevisionMecanicaService revisionMecanicaService;

    @GetMapping("/puntosRevision")
    public ResponseEntity<?> getPuntosRevision(@RequestParam String dbType){

        return ResponseEntity.ok(revisionMecanicaService.getPuntosRevision(dbType));
    }

    @PostMapping("/guardarRevision")
    public ResponseEntity<?> saveRevisionMecanica(@RequestBody RevisionDTO revisionDTO,@RequestParam String dbType){

        return ResponseEntity.ok(revisionMecanicaService.saveRevisionMecanica(revisionDTO,dbType));
    }



}
