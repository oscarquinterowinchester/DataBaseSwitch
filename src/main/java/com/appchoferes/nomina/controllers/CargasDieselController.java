package com.appchoferes.nomina.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appchoferes.nomina.dtos.CargasDiesel;
import com.appchoferes.nomina.dtos.MetodosPago;
import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.dtos.CamionCarga;
import com.appchoferes.nomina.services.CargasDieselService;
import com.appchoferes.nomina.services.MetodosPagoService;
import com.appchoferes.nomina.services.ProveedoresService;
import com.appchoferes.nomina.services.TiposCombustibleService;
import com.appchoferes.nomina.services.VistaCargaCamionService;
import com.appchoferes.nomina.services.CamionCargaService;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/cargasDiesel")
public class CargasDieselController {

    @Autowired
    CargasDieselService cargasDieselService;

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

    @GetMapping("")
    public ArrayList<CargasDiesel> getCargasDiesel(@RequestParam String choferId,@RequestParam String dbType) {
        return cargasDieselService.getCargasDiesel(choferId, dbType);
    }

   
    
   
    @GetMapping("/vistaCargaCamion")
    public VistaCargaCamion getVistaCamion(@RequestParam String choferId,@RequestParam String dbType) {

        return vistaCargaCamionService.getVistaCargaCamion(choferId, dbType);
    }
    
}
