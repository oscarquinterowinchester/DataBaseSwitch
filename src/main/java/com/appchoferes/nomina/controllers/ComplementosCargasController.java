package com.appchoferes.nomina.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.MetodoPago;
import com.appchoferes.nomina.dtos.ProveedoresCombustible;
import com.appchoferes.nomina.dtos.TipoCombustible;
import com.appchoferes.nomina.services.MetodoPagoService;
import com.appchoferes.nomina.services.ProveedoresService;
import com.appchoferes.nomina.services.TiposCombustibleService;

@RestController
@RequestMapping("/v1/complemento")
public class ComplementosCargasController {


    @Autowired
    ProveedoresService proveedoresService;

    @Autowired
    TiposCombustibleService tiposCombustibleService;

    @Autowired
    MetodoPagoService metodoPagoService;

    @RequestMapping("/tipoCombustible")
    public List<TipoCombustible> getTiposCombustible(@RequestParam String dbType){

        return tiposCombustibleService.getTipoCombustibles(dbType);
        
    }

    @RequestMapping("/proveedores")
    public List<ProveedoresCombustible> getProveedoresCombustible(@RequestParam String dbType){

        return proveedoresService.getProveedoresCombustible(dbType);
        
    }

    @RequestMapping("/metodoPago")
    public List<MetodoPago> getMetodoPago(@RequestParam String dbType){

        return metodoPagoService.getMetodoPagos(dbType);
        
    }




}
