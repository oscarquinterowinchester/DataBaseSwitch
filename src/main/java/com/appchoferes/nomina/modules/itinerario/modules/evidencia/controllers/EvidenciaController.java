package com.appchoferes.nomina.modules.itinerario.modules.evidencia.controllers;
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

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.TipoEvidenciaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.requests.DTO.EvidenciasDTO;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.services.EvidenciasService;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.services.ListaInspeccionChoferService;

@RestController
@RequestMapping("/api/drivermove/evidencia")
@CrossOrigin(origins = "http://localhost:4200")  
public class EvidenciaController {

    @Autowired
    ListaInspeccionChoferService listadoService;

    @Autowired
    EvidenciasService evidenciasService;

@PostMapping("/setEvidencia")
    public ResponseEntity<?> setEvidencia(@RequestBody EvidenciasDTO evidenciasDTO,
     @RequestParam String dbType){

        String mensaje  = evidenciasService.guardarEvidencias(evidenciasDTO,dbType);

        return ResponseEntity.ok(mensaje);
    }

@GetMapping("/getTipoEvidencias")
public ResponseEntity<?> getTipoEvidencias(@RequestParam String dbType){

    List<TipoEvidenciaDTO> lista = evidenciasService.getTipoEvidencias(dbType);

    return ResponseEntity.ok(lista);
}

}