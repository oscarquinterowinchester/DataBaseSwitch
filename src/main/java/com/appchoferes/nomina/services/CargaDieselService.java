package com.appchoferes.nomina.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CargasDieselEntity;
import com.appchoferes.nomina.operaciones.UtilsCarga;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.repositories.CargasDieselReporsitory;

import com.appchoferes.nomina.validators.Validador;

@Service
public class CargaDieselService {


    @Autowired
    CargasDieselReporsitory cargasDieselReporsitory;

    @Autowired
    Validador val;

    public CargasDieselEntity obtenerCargaPorId(String cargaId,String dbType)
    {
        Utils.establecerBaseDatos(dbType);
        return cargasDieselReporsitory.findByCargaId(Integer.parseInt(cargaId));
    }

    public ResponseEntity<String> procesarCarga(CargasDieselEntity carga,String dbType)
    {
        Map<String,Object> errores = null;
        Boolean campoEsValido = false;

        if(carga == null){
            return ResponseEntity.badRequest().body("Error en los formatos, error en la carga "); // Invalid data
        }

        errores = UtilsCarga.datosCargaSonValidos(carga);
        campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body("Error en los formatos: "+ errores.get("campoErroneo")); // Invalid data
        }

        Utils.establecerBaseDatos(dbType);
        

        String odometroUltimo = cargasDieselReporsitory.obtenerUltimoOdometro(carga.getUnidadId()+"", carga.getTipo(), 0);

        System.out.println("Ultimo odo: " + odometroUltimo);
        
        // cargasDieselReporsitory.save(carga);

        return ResponseEntity.ok("Se ha guardado correctamente");
    }

    public ResponseEntity<String> actualizarCargaPorCampos(String cargaId, Map<String, Object> campos, String dbType) {
        
        Map<String,Object> errores = null;
        int cargaIdInt = Validador.validarInteger(cargaId); 

        if(cargaIdInt <= 0)
        {
            return ResponseEntity.badRequest().body("Error en formato, cargaId no valida");
        }

        Utils.establecerBaseDatos(dbType);

        CargasDieselEntity cargaExistente = cargasDieselReporsitory.findByCargaId(cargaIdInt);

        errores = UtilsCarga.datosCargaSonValidos(cargaExistente);
        Boolean campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));
        String mensajeError = "Error en los formatos: "+ errores.get("campoErroneo");

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body(mensajeError); // Invalid data
        }

        cargaExistente = UtilsCarga.asignarDatosDeCarga(campos, cargaExistente);
        
        cargasDieselReporsitory.save(cargaExistente);
    
        return ResponseEntity.ok("Actualizado con exito"); // Retornar la entidad actualizada
    }

    
    


}
