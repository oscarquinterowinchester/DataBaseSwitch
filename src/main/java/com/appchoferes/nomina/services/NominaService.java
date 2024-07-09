package com.appchoferes.nomina.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Extras;
import com.appchoferes.nomina.dtos.ExtrasDTO;
import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.repositories.IExtrasRepository;
import com.appchoferes.nomina.repositories.INominaRepository;

@Service
public class NominaService {

    @Autowired
    private INominaRepository nominaRepository;

    @Autowired
    private IExtrasRepository extrasRepository;

    public ArrayList<Nomina> getNomina(String week, Long choferID, String dbType){
        try {
            DatabaseContextHolder.setDatabaseType(dbType);
            ArrayList<Nomina> nominas = (ArrayList<Nomina>) nominaRepository.getNominas(week, choferID);
            for (Nomina nomina : nominas) {
                ArrayList<Extras> extras = new ArrayList<Extras>(); 
                try {
                    ArrayList<ExtrasDTO> extrasDTO =  (ArrayList<ExtrasDTO>)extrasRepository.getExtras(nomina.getId());
                    for (ExtrasDTO extra : extrasDTO) {
                        System.out.println(extra);
                        Extras extraAux = new Extras();
                        extraAux.setId(extra.getId());
                        extraAux.setAmount(extra.getQuantity());
                        extraAux.setM0(extra.getAmount());
                        extraAux.setM1(extra.getAmount());
                        extraAux.setName(extra.getDescription());
                        extraAux.setDivisa(extra.getDivisa());
                        extras.add(extraAux);
                    }
                } catch (Exception e) {
                    throw new ErrorInternoException("Error al obtener extras para la nomina");
                }
                nomina.setExtras(extras);
            }
            return (ArrayList<Nomina>) nominas;
        } catch (Exception e) {
            throw new ErrorInternoException("Error al procesar la solicitud de nominas.");
        }
    }
}
