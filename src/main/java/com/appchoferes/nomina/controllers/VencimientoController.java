package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.Vencimiento;
import com.appchoferes.nomina.services.VencimientoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/vencimiento")
public class VencimientoController {
    @Autowired
    VencimientoService vencimientoService;

    @GetMapping("")
    public ArrayList<Vencimiento> getVencimientos(@RequestParam String choferId,@RequestParam String dbType){
        return vencimientoService.getVencimiento(choferId, dbType);
    }
}
