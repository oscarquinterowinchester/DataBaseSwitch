package com.appchoferes.app.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.CargasDiesel;
import com.appchoferes.app.repositories.ICargasDieselRepository;

@Service
public class CargasDieselService {
    @Autowired
    ICargasDieselRepository cargasDieselRepository;

    public ArrayList<CargasDiesel> getCargasDiesel(String choferId,String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<CargasDiesel>) cargasDieselRepository.getCargasDiesel(choferId);
    }

}