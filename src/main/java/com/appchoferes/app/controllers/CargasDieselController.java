package com.appchoferes.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.app.dtos.CargasDiesel;
import com.appchoferes.app.dtos.VistaCargaCamion;
import com.appchoferes.app.models.CargasDieselEntity;
import com.appchoferes.app.services.CamionCargaService;
import com.appchoferes.app.services.CargaDieselEntService;
import com.appchoferes.app.services.CargasDieselService;
import com.appchoferes.app.services.MetodosPagoService;
import com.appchoferes.app.services.ProveedoresService;
import com.appchoferes.app.services.TiposCombustibleService;
import com.appchoferes.app.services.VistaCargaCamionService;

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
   
   @Autowired
   CargaDieselEntService cargaDieselEntService;

    @GetMapping("")
    public ArrayList<CargasDiesel> getCargasDiesel(@RequestParam String choferId,@RequestParam String dbType) {
        return cargasDieselService.getCargasDiesel(choferId, dbType);
    }
@GetMapping("/vistaCargaCamion")
    public VistaCargaCamion getVistaCamion(@RequestParam String choferId,@RequestParam String dbType) {

        return vistaCargaCamionService.getVistaCargaCamion(choferId, dbType);
    }

    @GetMapping("/cargaDieselT")
    public ArrayList<CargasDieselEntity> getCargaDiesel(@RequestParam String cargaId,@RequestParam String dbType) {
        return cargaDieselEntService.getCargaDiesel(cargaId, dbType);
    }
    

    
    
}
