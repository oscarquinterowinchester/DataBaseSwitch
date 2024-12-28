package com.appchoferes.nomina.modules.itinerario.modules.combustible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.VentanaHistorialCarga;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.services.VentanaHistorialCargaService;

@RestController
@RequestMapping("/api/drivermove/combustible")
public class CargaCombustibleController {

    @Autowired
    VentanaHistorialCargaService ventanaInformacionService;

    @GetMapping("/historial")
    private ResponseEntity<?> getVentanaHistorialCargas(@RequestParam Long unidadId,@RequestParam int tipo,
     @RequestParam String dbType ){ 

        VentanaHistorialCarga ventanaHistorial  = ventanaInformacionService.getVentanaHistorialCarga(unidadId, tipo,dbType);

        return ResponseEntity.ok(ventanaHistorial);
    }

}
