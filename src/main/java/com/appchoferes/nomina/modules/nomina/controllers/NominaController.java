package com.appchoferes.nomina.modules.nomina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appchoferes.nomina.modules.nomina.dto.NominaInformacionDTO;
import com.appchoferes.nomina.modules.nomina.dto.SemanasNominaDTO;
import com.appchoferes.nomina.modules.nomina.services.INominaService;
import com.appchoferes.nomina.modules.nomina.services.SemanasNominaService;

@RestController
@RequestMapping("/api/nomina")
public class NominaController {
@Autowired
private INominaService nominaService;   

@Autowired
private SemanasNominaService semanasNominaService;


@GetMapping("")
public  ResponseEntity<?> getNominaPago(@RequestParam String semanaId, @RequestParam Long choferId, @RequestParam String dbType){

NominaInformacionDTO nominaPago = nominaService.getNominaPago(semanaId, choferId, dbType);

return ResponseEntity.ok(nominaPago);
}


@GetMapping("/semanasNomina")
public  ResponseEntity<?> getSemanasNomina(@RequestParam String dbType){

    List<SemanasNominaDTO> semanas =  semanasNominaService.getSemanasNomina(dbType);

return ResponseEntity.ok(semanas);
}


}
