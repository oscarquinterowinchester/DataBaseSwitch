package com.appchoferes.app.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.CamionCarga;
import com.appchoferes.app.repositories.ICamionCargaRepository;

@Service
public class CamionCargaService {

    @Autowired
    ICamionCargaRepository vistaCamionCarga;

    public CamionCarga getVistaCamionCargas(String choferId,String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return vistaCamionCarga.getCamionCarga(choferId);

    }


}
