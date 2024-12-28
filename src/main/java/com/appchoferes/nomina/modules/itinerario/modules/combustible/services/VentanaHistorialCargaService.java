package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.CargasHistorialPrevio;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.VentanaHistorialCarga;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CamionesConCargaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CombustibleCargasDieselRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class VentanaHistorialCargaService implements IVentanaHistorialCargaService{


    @Autowired 
    CombustibleCargasDieselRepository combustibleCargaRepo;

    @Autowired
    CamionesConCargaRepository camionesConCargaRepo;

    @Override
    public VentanaHistorialCarga getVentanaHistorialCarga(Long unidadId, int tipoUnidad, String dbType) {
        
        Utils.establecerBaseDatos(dbType);

        VentanaHistorialCarga ventanaInformacion = new VentanaHistorialCarga();

        ventanaInformacion.builder()
        .camion(camionesConCargaRepo.getCamionRaw(unidadId))
        .historial(combustibleCargaRepo.getHistorialCargas(unidadId, tipoUnidad));

        return ventanaInformacion;

    }

}


