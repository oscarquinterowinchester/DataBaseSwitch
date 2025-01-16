package com.appchoferes.nomina.modules.itinerario.modules.sello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.sello.DTO.SelloDTO;
import com.appchoferes.nomina.modules.itinerario.modules.sello.models.SelloEntity;
import com.appchoferes.nomina.modules.itinerario.modules.sello.repositories.SelloRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class SelloServiceImpl implements ISelloService{

    @Autowired
    Utils utils;

    @Autowired
    SelloRepository selloRepository;


    @Override
    public List<SelloEntity> getSellosByItinerarioId(int itinerarioId, String dbType) {

        utils.establecerBaseDatos(dbType);

        return  selloRepository.getSellosByItinerarioId(itinerarioId);
         
    }

    
public void guardarSellos(SelloDTO selloDTO, String dbType){


    int clienteId = selloRepository.getClienteSelloByItinearioId(selloDTO.getItinerario());

    SelloEntity selloEntity = SelloEntity.builder()
    .clienteId(clienteId)
    .itinerarioId(selloDTO.getItinerario())
    .sello(selloDTO.getSello())
    .nota(selloDTO.getNota())
    .build();


}


}
