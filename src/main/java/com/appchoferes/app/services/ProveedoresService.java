package com.appchoferes.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.ProveedoresCombustible;
import com.appchoferes.app.repositories.IProveedoresRepository;

@Service
public class ProveedoresService {

@Autowired
IProveedoresRepository proveedoresService;

public ArrayList<ProveedoresCombustible> getProveedoresCombustible(String dbType){
    DatabaseContextHolder.setDatabaseType(dbType);
    return (ArrayList<ProveedoresCombustible>) proveedoresService.getProveedoresCombustible();
}


}
