package com.appchoferes.app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.app.dtos.TipoCombustible;
import com.appchoferes.app.services.TiposCombustibleService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/tiposCombustible")

public class TiposCombustibleController {
    @Autowired
    TiposCombustibleService tiposCombustibleService;

    @GetMapping("")
    public ArrayList<TipoCombustible> getTipoCombustible(@RequestParam String dbType) {
        return tiposCombustibleService.getTipoCombustibles(dbType);
    }
    

}