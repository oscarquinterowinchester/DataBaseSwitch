package com.appchoferes.nomina.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CamionCarga;
import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.repositories.ICamionCargaRepository;
import com.appchoferes.nomina.repositories.IProveedoresRepository;

@Service
public class VistaCargaCamionService {

    @Autowired
    ICamionCargaRepository camionCargaRepository;
    @Autowired
    IProveedoresRepository proveedoresRepository;

    public VistaCargaCamion getVistaCargaCamion(String choferId, String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);

        VistaCargaCamion vistaCamionCarga = new VistaCargaCamion();

        CamionCarga camionCarga = new CamionCarga();

        camionCarga = camionCargaRepository.getCamionCarga(choferId);

        vistaCamionCarga.setCamionId(camionCarga.getCamionId());
        vistaCamionCarga.setNoEconomico(camionCarga.getNoEconomico());
        vistaCamionCarga.setTanqueActual(camionCarga.getTanqueActual());

        vistaCamionCarga.setProveedores(proveedoresRepository.getProveedoresCombustible());


        return vistaCamionCarga;
    }


}
