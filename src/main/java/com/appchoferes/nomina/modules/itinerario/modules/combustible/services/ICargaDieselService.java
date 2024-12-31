package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.models.CargasDieselEntity;


@Service
public interface ICargaDieselService {

    public CargasDieselEntity obtenerCargaPorId(String cargaId,String dbType);

    public ResponseEntity<String> procesarCarga(CargasDieselEntity carga,String dbType);

    public ResponseEntity<String> actualizarCargaPorCampos(String cargaId, Map<String, Object> campos, String dbType);

}
