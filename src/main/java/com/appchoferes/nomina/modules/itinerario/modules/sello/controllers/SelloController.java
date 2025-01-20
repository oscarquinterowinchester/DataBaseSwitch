package com.appchoferes.nomina.modules.itinerario.modules.sello.controllers;

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

import com.appchoferes.nomina.modules.itinerario.modules.sello.DTO.SelloDTO;
import com.appchoferes.nomina.modules.itinerario.modules.sello.DTO.SelloRotoDTO;
import com.appchoferes.nomina.modules.itinerario.modules.sello.models.SelloEntity;
import com.appchoferes.nomina.modules.itinerario.modules.sello.services.SelloServiceImpl;

@RestController
@RequestMapping("/api/drivermove/sello")
@CrossOrigin(origins = "http://localhost:4200")  
public class SelloController {


    @Autowired
    SelloServiceImpl selloServiceImpl;

    @GetMapping("/getSellos")
    public List<SelloEntity> getSellosByItinerarioId(@RequestParam int itinerario, @RequestParam  String dbType){

       return selloServiceImpl.getSellosByItinerarioId(itinerario, dbType);
    }


    @PostMapping("/guardarSello")
    public ResponseEntity<?> guardarSelloItinerario(@RequestBody SelloDTO selloDTO,@RequestParam String dbType){

        String respuesta = selloServiceImpl.guardarSellos(selloDTO, dbType);

        return ResponseEntity.ok(respuesta);
    }
    
    
    @PostMapping("/romperSello")
    public ResponseEntity<?> guardarRomperSello(@RequestBody SelloRotoDTO selloDTO,@RequestParam String dbType){

        selloServiceImpl.romperSello(selloDTO, dbType);

        return ResponseEntity.ok("procesado con exito");
    }
    

}
