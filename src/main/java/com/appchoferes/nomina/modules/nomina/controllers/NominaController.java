package com.appchoferes.nomina.modules.nomina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.errors.NotFoundException;
import com.appchoferes.nomina.modules.nomina.dto.NominaInformacionDTO;
import com.appchoferes.nomina.modules.nomina.models.NominaEntity;
import com.appchoferes.nomina.modules.nomina.services.INominaService;

@RestController
@RequestMapping("/api/nomina")
public class NominaController {
@Autowired
private INominaService nominaService;   



@GetMapping("")
public  ResponseEntity<?> getNominaPago(@RequestParam String semanaId, @RequestParam Long choferId, @RequestParam String dbType){

NominaInformacionDTO nominaPago = nominaService.getNominaPago(semanaId, choferId, dbType);

return ResponseEntity.ok(nominaPago);
}



// @GetMapping("")
// public  ResponseEntity<?> getNomina(@RequestParam String semanaId, @RequestParam Long choferId, @RequestParam String dbType){
// try {

//         List<NominaEntity> nominas = nominaService.getNomina(semanaId, choferId, dbType);
//         return ResponseEntity.ok(nominas);


//     } catch (NotFoundException | ErrorInternoException e) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
//     }
// }



}
