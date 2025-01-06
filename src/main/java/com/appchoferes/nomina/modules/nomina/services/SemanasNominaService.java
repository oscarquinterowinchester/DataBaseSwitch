package com.appchoferes.nomina.modules.nomina.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.nomina.dto.SemanasNominaDTO;
import com.appchoferes.nomina.modules.nomina.repositories.SemanasNominaRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class SemanasNominaService {

    @Autowired
    SemanasNominaRepository semanasNominaRepository;

    @Autowired
    Utils utils;

    public List<SemanasNominaDTO> getSemanasNomina(String dbType){

        utils.establecerBaseDatos(dbType);

       return  semanasNominaRepository.getSemanasNomina();

    }


}
