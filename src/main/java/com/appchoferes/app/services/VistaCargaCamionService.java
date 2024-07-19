package com.appchoferes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.dtos.CamionCarga;
import com.appchoferes.app.dtos.CargasDiesel;
import com.appchoferes.app.dtos.VistaCargaCamion;
import com.appchoferes.app.repositories.ICamionCargaRepository;
import com.appchoferes.app.repositories.ICargasDieselRepository;
import com.appchoferes.app.repositories.IMetodosPagoRepository;
import com.appchoferes.app.repositories.IProveedoresRepository;
import com.appchoferes.app.repositories.ITiposCombustibleRepository;

@Service
public class VistaCargaCamionService {

    @Autowired
    ICamionCargaRepository camionCargaRepository;
    @Autowired
    IProveedoresRepository proveedoresRepository;
    @Autowired
    ICargasDieselRepository cargasDieselRepository;
    @Autowired
    ITiposCombustibleRepository tiposCombustibleRepository;
    @Autowired
    IMetodosPagoRepository metodosPagoRepository;

    public VistaCargaCamion getVistaCargaCamion(String choferId, String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);

        VistaCargaCamion vistaCamionCarga = new VistaCargaCamion();

        CamionCarga camionCarga = new CamionCarga();

        camionCarga = camionCargaRepository.getCamionCarga(choferId);

        vistaCamionCarga.setCamionId(camionCarga.getCamionId());
        vistaCamionCarga.setNoEconomico(camionCarga.getNoEconomico());
        vistaCamionCarga.setTanqueActual(camionCarga.getTanqueActual());

        List<CargasDiesel> cargasDiesel = cargasDieselRepository.getCargasDiesel(choferId);

        vistaCamionCarga.setCargasDiesel(cargasDiesel);
        vistaCamionCarga.setProveedores(proveedoresRepository.getProveedoresCombustible());
        vistaCamionCarga.setMetodosPagos(metodosPagoRepository.getMetodosPago());
        vistaCamionCarga.setTipoCombustibles(tiposCombustibleRepository.getTipoCombustible());
        return vistaCamionCarga;
    }

}
