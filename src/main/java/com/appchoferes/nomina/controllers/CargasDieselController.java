package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appchoferes.nomina.dtos.CargasDiesel;
import com.appchoferes.nomina.dtos.CargasDieselEntity;
import com.appchoferes.nomina.dtos.MetodosPago;
import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.dtos.CamionCarga;
import com.appchoferes.nomina.services.CargasDieselService;
import com.appchoferes.nomina.services.MetodosPagoService;
import com.appchoferes.nomina.services.ProveedoresService;
import com.appchoferes.nomina.services.TiposCombustibleService;
import com.appchoferes.nomina.services.VistaCargaCamionService;
import com.appchoferes.nomina.services.CamionCargaService;
import com.appchoferes.nomina.services.CargaDieselService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/cargasDiesel")
public class CargasDieselController {

    

   @Autowired
   CamionCargaService vistaCamionCargaService;

   @Autowired
   MetodosPagoService metodosPagoService;

   @Autowired
   TiposCombustibleService tiposCombustibleService;

   @Autowired
   ProveedoresService proveedoresService;

   @Autowired
   VistaCargaCamionService vistaCargaCamionService;

   @Autowired
   CargaDieselService cargasDieselService2;

    // @GetMapping("")
    // public ArrayList<CargasDiesel> getCargasDiesel(@RequestParam String choferId,@RequestParam String dbType) {
    //     return cargasDieselService.getCargasDiesel(choferId, dbType);
    // }

   
    
   
    @GetMapping("/vistaCargaCamion")
    public VistaCargaCamion getVistaCamion(@RequestParam String choferId,@RequestParam String dbType) {

        return vistaCargaCamionService.getVistaCargaCamion(choferId, dbType);
    }

    @GetMapping("/carga")
    public ArrayList<CargasDieselEntity> getMethodName(@RequestParam String choferId,@RequestParam String dbType) {
        return cargasDieselService2.getCargaDieselEntity(choferId, dbType);
    }

    @PostMapping("/insertarCarga")
    public String postMethodName(@RequestBody CargasDieselEntity entity) {
        //TODO: process POST request
        
        entity.setStatus(false);
        entity.setSellos("SELLO 1");
        cargasDieselService2.insertarCarga(entity, "noedb");
        return "Ecstpo";
    }
    
    
    
}
