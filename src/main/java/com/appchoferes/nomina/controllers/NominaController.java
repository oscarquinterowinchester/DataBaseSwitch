package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.services.NominaService;

@RestController
@RequestMapping("/nomina")
public class NominaController {
   @Autowired
   private NominaService nominaService;   
   
   @GetMapping("")
   public ArrayList<Nomina> getNomina(@RequestParam String week, @RequestParam Long choferID, @RequestParam String dbType){
    return nominaService.getNomina(week, choferID, dbType);
   }
}
