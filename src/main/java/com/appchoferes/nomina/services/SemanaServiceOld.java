package com.appchoferes.nomina.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Semana;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.repositories.ISemanaRepository;

@Service
public class SemanaServiceOld {

    @Autowired
    ISemanaRepository semanaRepository;
    
    public Semana getFechaIniyFin(String dbType, String semanaId)
    {
        Utils.establecerBaseDatos(dbType);
        return semanaRepository.getSemanas(semanaId);

    }

}
