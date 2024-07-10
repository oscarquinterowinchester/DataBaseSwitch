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
import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.errors.NotFoundException;
import com.appchoferes.nomina.services.NominaService;

@RestController
@RequestMapping("/nomina")
public class NominaController {
   @Autowired
   private NominaService nominaService;   
   
   @GetMapping("")
   public  ResponseEntity<?> getNomina(@RequestParam String week, @RequestParam Long choferID, @RequestParam String dbType){
    try {
            ArrayList<Nomina> nominas = nominaService.getNomina(week, choferID, dbType);
            return ResponseEntity.ok(nominas);
        } catch (NotFoundException | ErrorInternoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
   }
}
