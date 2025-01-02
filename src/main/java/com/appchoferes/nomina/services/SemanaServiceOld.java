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

    @Autowired
    Utils utils;
    
    public Semana getFechaIniyFin(String dbType, String semanaId)
    {
        utils.establecerBaseDatos(dbType);
        return semanaRepository.getSemanas(semanaId);

    }

}
