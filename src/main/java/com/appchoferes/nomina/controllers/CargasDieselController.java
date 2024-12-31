package com.appchoferes.nomina.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.models.CargasDieselEntity;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.services.CargaDieselService;
import com.appchoferes.nomina.services.MetodosPagoService;
import com.appchoferes.nomina.services.ProveedoresService;
import com.appchoferes.nomina.services.TiposCombustibleService;
import com.appchoferes.nomina.services.VistaCargaCamionService;
import com.appchoferes.nomina.services.CamionCargaService;






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
        return cargasDieselService.procesarCarga(entity, dbType);
    }

    @PatchMapping("/cargas/{cargaId}")
    public ResponseEntity<String> actualizarCargaPorCampos(@PathVariable String cargaId,@RequestBody Map<String,Object> campos,@RequestParam String dbType) {
        ResponseEntity<String> mensaje = cargasDieselService.actualizarCargaPorCampos(cargaId,campos,dbType);
        return mensaje;
    }

    

    
    
    
    
}
