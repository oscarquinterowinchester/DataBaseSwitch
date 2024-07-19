package com.appchoferes.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.models.CargasDieselEntity;
import com.appchoferes.app.repositories.ICargaDiesel;
import com.appchoferes.app.repositories.ICargasDieselRepository;

@Service
public class CargaDieselEntService {

    @Autowired
    ICargaDiesel cargasDiesel;

    public ArrayList<CargasDieselEntity> getCargaDiesel(String cargaId, String dbType){

        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<CargasDieselEntity>) cargasDiesel.findByCargaId(Integer.parseInt(cargaId));
    }

}
