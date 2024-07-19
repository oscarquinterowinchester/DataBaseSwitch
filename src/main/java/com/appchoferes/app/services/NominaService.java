package com.appchoferes.app.services;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.Extras;
import com.appchoferes.app.dtos.ExtrasDTO;
import com.appchoferes.app.dtos.Nomina;
import com.appchoferes.app.errors.ErrorInternoException;
import com.appchoferes.app.repositories.IExtrasRepository;
import com.appchoferes.app.repositories.INominaRepository;

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
