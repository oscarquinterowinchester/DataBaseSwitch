package com.appchoferes.nomina.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.dtos.MetodoPago;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.repositories.IMetodosPagoRepository;

@Service
public class MetodoPagoService {

@Autowired
IMetodosPagoRepository metodosPagoRepository;

@Autowired
Utils utils;

public List<MetodoPago> getMetodoPagos(String dbType){

    utils.establecerBaseDatos(dbType);

    return metodosPagoRepository.getMetodosPago();
}


}
