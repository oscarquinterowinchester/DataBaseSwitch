package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.dtos.NominaPago;
import com.appchoferes.nomina.dtos.Semana;
import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.errors.NotFoundException;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.services.NominaService;
import com.appchoferes.nomina.services.SemanaService;

@RestController
@RequestMapping("/getNominaChofer")
public class NominaController {
@Autowired
private NominaService nominaService;   

@Autowired
private SemanaService semanaService;



@GetMapping("/pago")
public  ResponseEntity<?> getNominaPago(@RequestParam String semanaId, @RequestParam Long choferId, @RequestParam String dbType){

NominaPago nominaPago = nominaService.getNominaPago(semanaId, choferId, dbType);

return ResponseEntity.ok(nominaPago);
}


@GetMapping("/semana")
public ResponseEntity<?> getSemana(@RequestParam String semanaId, @RequestParam String dbType)
{

Semana fechasIniyFin = semanaService.getFechaIniyFin(dbType, semanaId);
return ResponseEntity.ok(fechasIniyFin);
}


@GetMapping("")
public  ResponseEntity<?> getNomina(@RequestParam String semanaId, @RequestParam Long choferId, @RequestParam String dbType){
try {
        ArrayList<Nomina> nominas = nominaService.getNomina(semanaId, choferId, dbType);
        return ResponseEntity.ok(nominas);
    } catch (NotFoundException | ErrorInternoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
    }
}
}
