package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.CamionesConCargaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.CargasHistorialPrevio;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.VentanaHistorialCarga;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CamionesConCargaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CargasHistorialPrevioRepository;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CombustibleCargasDieselRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class VentanaHistorialCargaService implements IVentanaHistorialCargaService{


    @Autowired 
    CargasHistorialPrevioRepository historialRepo;

    @Autowired
    CamionesConCargaRepository camionesConCargaRepo;

    @Autowired
    Utils utils;

   private  String dbType = "";

    @Override
    public VentanaHistorialCarga getVentanaHistorialCarga(Long itinerarioId, String dbType) {
        
        utils.establecerBaseDatos(dbType);

        this.dbType = dbType;

        VentanaHistorialCarga ventanaInformacion = getVentanaInformacionByItinerarioId(itinerarioId);

        return ventanaInformacion;

    }


    public VentanaHistorialCarga getVentanaInformacionByItinerarioId(Long itinerarioId){

        utils.establecerBaseDatos(dbType);

        VentanaHistorialCarga ventanaInformacion = new VentanaHistorialCarga();

        CamionesConCargaDTO camion = getCamionByItinerarioId(itinerarioId);

        List<CargasHistorialPrevio> historial = getHistorialCargaByItinerarioId(itinerarioId);

        ventanaInformacion.setCamion(camion);
        ventanaInformacion.setHistorial(historial); 

        return ventanaInformacion;
    }

    public CamionesConCargaDTO getCamionByItinerarioId(Long itinerarioId){
        utils.establecerBaseDatos(dbType);

        CamionesConCargaDTO camion = camionesConCargaRepo.getCamionRaw(itinerarioId);    

        return camion;
    }

    public List<CargasHistorialPrevio> getHistorialCargaByItinerarioId(Long itinerarioId){

        utils.establecerBaseDatos(dbType);

        Long unidadId = getUnidadByItinerarioId(itinerarioId);

        int esTipoCamion = 0; // Choferes registraran solo camiones.

        List<CargasHistorialPrevio> historial = historialRepo.getHistorialCargas(unidadId, esTipoCamion);

        return historial;
    }
    public Long getUnidadByItinerarioId(Long itinerarioId){
        utils.establecerBaseDatos(dbType);

      return  camionesConCargaRepo.getCamionIdByItinerario(itinerarioId);

    }

}


