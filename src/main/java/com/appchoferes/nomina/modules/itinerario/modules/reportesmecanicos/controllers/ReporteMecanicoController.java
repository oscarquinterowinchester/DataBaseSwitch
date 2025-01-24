package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.ReporteMecanicoDTO;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models.RequisicionEntity;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.services.ReporteMecanicoService;

@RestController
@RequestMapping("/api/drivermove/inspeccion")
@CrossOrigin(origins = "http://localhost:4200")  
public class ReporteMecanicoController {

    @Autowired
    ReporteMecanicoService reporteMecanicoService;
    

    @PostMapping("/guardarReporte")
    public ResponseEntity<?> guardarReporteMecanico(@RequestBody ReporteMecanicoDTO reporte,@RequestParam String dbType){
        
       RequisicionEntity requisicion = reporteMecanicoService.guardarReporteMecanico(reporte, dbType);
        
        return ResponseEntity.ok(requisicion);
    }

    @GetMapping("/getCategorias")
    public ResponseEntity<?> getCategorias(@RequestParam String dbType){

        return ResponseEntity.ok(reporteMecanicoService.getCategorias(dbType));
    }

    @GetMapping("/getTipoFallas")
    public ResponseEntity<?> getTipoFallas(@RequestParam String dbType){

        return ResponseEntity.ok(reporteMecanicoService.getTipoFallasMecanicas(dbType));
    }

    @GetMapping("/getUnidadesObjeto")
    public ResponseEntity<?> getUnidadesObjeto(@RequestParam(name = "ItinerarioID")int itinerarioId, 
    @RequestParam(name = "CategoriaID") int categoriaId,
    @RequestParam String dbType){

        return ResponseEntity.ok(reporteMecanicoService.getUnidadesObjeto(itinerarioId, categoriaId, dbType));
    }

}
