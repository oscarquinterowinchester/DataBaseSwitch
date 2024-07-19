package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CargasDieselEntity;
import com.appchoferes.nomina.repositories.CargasDieselReporsitory;

@Service
public class CargaDieselService {


    @Autowired
    CargasDieselReporsitory cargasDieselReporsitory;

    public ArrayList<CargasDieselEntity> getCargaDieselEntity(String cargaId,String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<CargasDieselEntity>) cargasDieselReporsitory.findByCargaId(Integer.parseInt(cargaId));
    }
    public void insertarCarga(CargasDieselEntity carga,String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);
        cargasDieselReporsitory.save(carga);
    }

}
