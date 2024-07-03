package com.appchoferes.nomina.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.repositories.INominaRepository;

@Service
public class NominaService {

    @Autowired
    private INominaRepository nominaRepository;

    public ArrayList<Nomina> getNomina(String week, Long choferID, String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<Nomina>) nominaRepository.getNominas(week, choferID);
    }
}
