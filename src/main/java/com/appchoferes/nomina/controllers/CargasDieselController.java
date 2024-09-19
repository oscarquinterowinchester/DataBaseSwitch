package com.appchoferes.nomina.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/cargasCombustible")
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
   CargaDieselService cargasDieselService;

   
    @GetMapping("/cargarVistaCombustible")
    public VistaCargaCamion getVistaCamion(@RequestParam String choferId,@RequestParam String dbType) {
        // Toma la unidad del momento para el chofer.
        return vistaCargaCamionService.getVistaCargaCamion(choferId, dbType);
    }

    @GetMapping("/cargarPorId")
    public CargasDieselEntity getCargaPorId(@RequestParam String cargaId,@RequestParam String dbType) {
        return cargasDieselService.obtenerCargaPorId(cargaId, dbType);
    }

    @PostMapping("/insertarCarga")
    public ResponseEntity<String> insertarCarga(@RequestBody CargasDieselEntity entity,String dbType) {
        // return ResponseEntity.ok("Insertado correctamente");
        return cargasDieselService.procesarCarga(entity, dbType);
    }

    @PatchMapping("/cargas/{cargaId}")
    public ResponseEntity<String> actualizarCargaPorCampos(@PathVariable String cargaId,@RequestBody Map<String,Object> campos,@RequestParam String dbType) {
        cargasDieselService.actualizarCargaPorCampos(cargaId,campos,dbType);
        return ResponseEntity.ok("Actualizado correctamente");
    }

    

    
    
    
    
}
