package com.appchoferes.nomina.modules.vencimiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.vencimiento.repositories.VencimientoRepository;
import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.vencimiento.models.*;;

@Service
public class VencimientoService implements IVencimientoService {
    /*implements IVencimientoService */
    @Autowired
    VencimientoRepository vencimientoRepository;

    @Override
    public List<VencimientoEntity> getVencimiento(String choferId,String dbType){

        DatabaseContextHolder.setDatabaseType(dbType);
        return  vencimientoRepository.getVencimientos(choferId);

    }

}
