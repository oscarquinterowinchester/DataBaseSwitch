package com.appchoferes.nomina.modules.nomina.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.Extras;
import com.appchoferes.nomina.errors.ErrorInternoException;
import com.appchoferes.nomina.modules.nomina.dto.NominaInformacionDTO;
import com.appchoferes.nomina.modules.nomina.dto.SemanaDTO;
import com.appchoferes.nomina.modules.nomina.models.NominaEntity;
import com.appchoferes.nomina.modules.nomina.repositories.ExtrasRepository;
import com.appchoferes.nomina.modules.nomina.repositories.NominaRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.modules.nomina.dto.ExtrasDTO;

@Service
public class NominaService implements INominaService {

    @Autowired
    NominaRepository nominaRepository;

    @Autowired
    ISemanaService semanaService;

    @Autowired
    ExtrasRepository extrasRepository;

    @Autowired
    Utils utils;
    
    @Override
    public NominaInformacionDTO getNominaPago(String semanaId, Long choferId, String dbType)
    {

        utils.establecerBaseDatos(dbType);

        SemanaDTO fechasIniyFin = semanaService.getFechaIniyFin(dbType, semanaId);
        ArrayList<NominaEntity> nominas = getNomina(semanaId, choferId, dbType);

        NominaInformacionDTO nominaPago = new NominaInformacionDTO();

        nominaPago.setSemanas(fechasIniyFin);
        nominaPago.setViajes(nominas);
        nominaPago.setAutorizados(0);
        nominaPago.setDescuento(getDescuentoNomina(semanaId,Utils.toStr(choferId), dbType,nominas));
        nominaPago.setPendientes(0);
        nominaPago.setTotal(0);

        return nominaPago;

    }
    

    @Override
    public float getDescuentoNomina(String semanaId, String choferId, String dbType, List<NominaEntity> nominas){


        utils.establecerBaseDatos(dbType);

        float descuento = 0.0F;

        for(NominaEntity nomina : nominas){

            descuento = descuento + nominaRepository.getDescuento(semanaId, choferId, nomina.getItinerarioId()+"");
        }

        return  descuento;
    }

    @Override
    public ArrayList<NominaEntity> getNomina(String week, Long choferID, String dbType){
        try {
            DatabaseContextHolder.setDatabaseType(dbType);
            List<NominaEntity> nominas = nominaRepository.getNominas(week, choferID);

            for (NominaEntity nomina : nominas) {

                ArrayList<Extras> extras = new ArrayList<Extras>(); 
                try {
                    List<ExtrasDTO> extrasDTO =  extrasRepository.getExtras(nomina.getItinerarioId());

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
            return (ArrayList<NominaEntity>) nominas;
        } catch (Exception e) {
            throw new ErrorInternoException("Error al procesar la solicitud de nominas.");
        }
    }

}
