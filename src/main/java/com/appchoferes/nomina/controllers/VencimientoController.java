package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.Vencimiento;
import com.appchoferes.nomina.services.VencimientoService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:4200")  
// Revisar por si no agarra
@RequestMapping("/vencimiento")
public class VencimientoController {
    @Autowired
    VencimientoService vencimientoService;

    @GetMapping("")
    public ArrayList<Vencimiento> getVencimientos(@RequestParam String choferId,@RequestParam String dbType){


        JSONObject data = new JSONObject();
        JSONObject objeto = new JSONObject();

        data.put("vencidos",0);
        data.put("bien",4);
        


        return vencimientoService.getVencimiento(choferId, dbType);
    }
}
