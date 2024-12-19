package com.appchoferes.nomina.modules.nomina.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.nomina.dto.NominaInformacionDTO;
import com.appchoferes.nomina.modules.nomina.models.NominaEntity;


@Service
public interface INominaService {

    public NominaInformacionDTO getNominaPago(String semanaId, Long choferId, String dbType);

    public float getDescuentoNomina(String semanaId, String choferId, String dbType,List<NominaEntity> nominas);

    public List<NominaEntity> getNomina(String week, Long choferID, String dbType);


}
