package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Vencimiento;
import com.appchoferes.nomina.repositories.IVencimientoRepository;

@Service
public class VencimientoService {

    @Autowired
    IVencimientoRepository vencimientoRepository;

    public ArrayList<Vencimiento> getVencimiento(String choferId,String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<Vencimiento>) vencimientoRepository.getVencimientos(choferId);
    }
}
