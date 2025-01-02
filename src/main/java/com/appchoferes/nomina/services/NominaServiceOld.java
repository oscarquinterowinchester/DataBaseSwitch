package com.appchoferes.nomina.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Extras;
import com.appchoferes.nomina.dtos.ExtrasDTOOld;
import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.dtos.NominaPago;
import com.appchoferes.nomina.dtos.Semana;
import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.repositories.IExtrasRepository;
import com.appchoferes.nomina.repositories.INominaRepository;

@Service
public class NominaServiceOld {

    @Autowired
    private INominaRepository nominaRepository;

    @Autowired
    private IExtrasRepository extrasRepository;

    @Autowired
    private SemanaServiceOld semanaService;

    @Autowired
    Utils utils;


    public NominaPago getNominaPago(String semanaId, Long choferId, String dbType){

        utils.establecerBaseDatos(dbType);

        Semana fechasIniyFin = semanaService.getFechaIniyFin(dbType, semanaId);
        ArrayList<Nomina> nominas = getNomina(semanaId, choferId, dbType);

        NominaPago nominaPago = new NominaPago();

        nominaPago.setSemanas(fechasIniyFin);
        nominaPago.setViajes(nominas);
        nominaPago.setAutorizados(0);
        nominaPago.setDescuento(getDescuentoNomina(semanaId,Utils.toStr(choferId), dbType,nominas));
        nominaPago.setPendientes(0);
        nominaPago.setTotal(0);

        return nominaPago;

    }

    public float getDescuentoNomina(String semanaId, String choferId, String dbType,ArrayList<Nomina> nominas){


        utils.establecerBaseDatos(dbType);

        float descuento = 0.0F;

        for(Nomina nomina : nominas){

            descuento = descuento + nominaRepository.getDescuento(semanaId, choferId, nomina.getItinerarioId()+"");
        }

        return  descuento;
    }

    public ArrayList<Nomina> getNomina(String week, Long choferID, String dbType){
        try {
            DatabaseContextHolder.setDatabaseType(dbType);
            ArrayList<Nomina> nominas = (ArrayList<Nomina>) nominaRepository.getNominas(week, choferID);
            for (Nomina nomina : nominas) {
                ArrayList<Extras> extras = new ArrayList<Extras>(); 
                try {
                    ArrayList<ExtrasDTOOld> extrasDTO =  (ArrayList<ExtrasDTOOld>)extrasRepository.getExtras(nomina.getItinerarioId());
                    for (ExtrasDTOOld extra : extrasDTO) {
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
