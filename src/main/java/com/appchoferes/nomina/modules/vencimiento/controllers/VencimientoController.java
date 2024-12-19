package com.appchoferes.nomina.modules.vencimiento.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.vencimiento.models.VencimientoEntity;
import com.appchoferes.nomina.modules.vencimiento.services.VencimientoService;

@RequestMapping("/api/vencimiento")
@RestController
public class VencimientoController {

@Autowired

    VencimientoService vencimientoService;

    @GetMapping("")
    public List<VencimientoEntity> getVencimientos(@RequestParam String choferId,@RequestParam String dbType){
        
        return vencimientoService.getVencimiento(choferId, dbType);
        
    }

}
