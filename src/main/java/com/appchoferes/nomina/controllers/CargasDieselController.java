package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appchoferes.nomina.dtos.CargasDiesel;
import com.appchoferes.nomina.services.CargasDieselService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/cargasDiesel")
public class CargasDieselController {

    @Autowired
    CargasDieselService cargasDieselService;

    @GetMapping("")
    public ArrayList<CargasDiesel> getCargasDiesel(@RequestParam String choferId,@RequestParam String dbType) {
        return cargasDieselService.getCargasDiesel(choferId, dbType);
    }
   
}
