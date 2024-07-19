package com.appchoferes.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.MetodosPago;
import com.appchoferes.app.repositories.IMetodosPagoRepository;

@Service
public class MetodosPagoService {

    @Autowired
    IMetodosPagoRepository metodosPagoRepository;

    public ArrayList<MetodosPago> getMetodosPagos(String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<MetodosPago>) metodosPagoRepository.getMetodosPago();
    }


}