package com.appchoferes.nomina.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.ContenedorItinerario;
import com.appchoferes.nomina.dtos.ItinerarioChofer;
import com.appchoferes.nomina.dtos.ItinerarioChoferInfo;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.repositories.IContenedorItinerarioRepository;
import com.appchoferes.nomina.repositories.ItinerarioChoferRepository;

@Service
public class ItinerarioChoferService {



    @Autowired
    ItinerarioChoferRepository itiChoferRepo;

    @Autowired
    IContenedorItinerarioRepository contenedorRepo;
    

    public int setItinerarioAsVisto(String itinerarioId,String dbType)
    {
        Utils.establecerBaseDatos(dbType);

        return itiChoferRepo.setItinerarioAsVisto(itinerarioId);
        
    }

    public ItinerarioChoferInfo getItinerario(String choferId,String dbType)
    {

        Utils.establecerBaseDatos(dbType);

        ItinerarioChoferInfo data = new ItinerarioChoferInfo();

        data.setData(itiChoferRepo.getItinerarioChofer(choferId));

        for(ItinerarioChofer iti : data.getData()){

            List<ContenedorItinerario> contenedor =   contenedorRepo.getContenedorIti(Utils.toStr(iti.getId()));
            iti.setContenedores(contenedor);

            }
        
        data.set_estatus(20);
        data.set_message("Datos encontrados");
        data.setCount(1);

        
        return data;
    
    }
            
               
    
}
