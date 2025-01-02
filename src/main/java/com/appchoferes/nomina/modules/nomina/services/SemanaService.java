package com.appchoferes.nomina.modules.nomina.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.nomina.dto.SemanaDTO;
import com.appchoferes.nomina.modules.nomina.repositories.SemanaRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class SemanaService implements ISemanaService
{

    @Autowired
    SemanaRepository semanaRepository;

    @Autowired
    Utils utils;
    
    public SemanaDTO getFechaIniyFin(String dbType, String semanaId)
    {
        utils.establecerBaseDatos(dbType);
        return semanaRepository.getSemanas(semanaId);

    }

}
