package com.appchoferes.nomina.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.ItinerarioChoferInfo;
import com.appchoferes.nomina.services.ItinerarioChoferService;

@RestController
@RequestMapping("/getItinerarios")
public class ItinerarioController {

    @Autowired
    ItinerarioChoferService itinerarioService;


    @GetMapping("")
    public ResponseEntity<?> getItinerariosChofer(@RequestParam String choferId,@RequestParam String dbType)
    {
           
       ItinerarioChoferInfo itinerarios = itinerarioService.getItinerario(choferId,dbType);

        return ResponseEntity.ok(itinerarios);
    }
    
    @GetMapping("/visto")
    public ResponseEntity<?> setItinerarioAsVisto(@RequestParam String id,@RequestParam String dbType)
    {
       int estatus = itinerarioService.setItinerarioAsVisto(id,dbType);

        return ResponseEntity.ok(estatus);
    }


}
