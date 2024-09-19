package com.appchoferes.nomina.operaciones;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import com.appchoferes.nomina.dtos.CargasDieselEntity;
import com.appchoferes.nomina.repositories.CargasDieselReporsitory;
import com.appchoferes.nomina.validators.Validador;

public class UtilsCarga {
    @Autowired
    static CargasDieselReporsitory cargasDieselReporsitory;

    


    public static CargasDieselEntity asignarDatosDeCarga(Map<String, Object> campos, CargasDieselEntity cargaExistente){

        campos.forEach((key, value) -> {
            // Usar reflection para encontrar el setter correspondiente
            String setterName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1); // Generar el nombre del setter
            Method setter = ReflectionUtils.findMethod(CargasDieselEntity.class, setterName, value.getClass());
            try {
                if (setter == null) {
                    System.out.println("No se encontro un setter para el campo: " + setterName+ " value: "+ value.getClass());
                    return; // Terminar esta iteración y pasar a la siguiente
                }
                setter.invoke(cargaExistente, value); // Invocar el setter
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("Error invocando el metodo setter: " + e.getMessage());
            }
        });

        return cargaExistente;
    }

    public static Map<String,Object> datosCargaSonValidos(CargasDieselEntity carga){
        
        Map<String,Object> errores = new HashMap<>();
        if(carga == null){
            errores.put("campoErroneo", "Carga invalida");
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(carga.getTipo()) > 1 || Validador.validarInteger(carga.getTipo()) < 0){
            errores.put("campoErroneo", "Tipo unidad invalido: " + carga.getTipo());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(carga.getUnidadId()) <= 0)
        {
            errores.put("campoErroneo", "UnidadID: " + carga.getUnidadId());
            errores.put("esValido", false);
            return errores; 
        }
        if(Validador.validarInteger(carga.getTipoCombustible()) <= 0 ){
            errores.put("campoErroneo", "Tipo de combustible no valido: " + carga.getTipoCombustible());
            errores.put("esValido", false);    
            return errores;
        }
        if(Validador.validarDouble(carga.getLitros()) <= 0.0)
        {
            errores.put("campoErroneo", "Litros no validos; no puede ser 0 y no numerico: " + carga.getLitros());
            errores.put("esValido", false);
            return errores;      
        }
        if(Validador.validarDouble(carga.getOdometroCarga()) <= 0.0)
        {
            errores.put("campoErroneo", "Odometro no valido; no puede ser 0 o mayor 4000 del ultimo: " + carga.getOdometroCarga());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarDate(String.valueOf(carga.getFecha())) == null)
        {
            errores.put("campoErroneo", "Fecha: " + carga.getFecha());
            errores.put("esValido", false);   
            return errores;
        }
        if(Validador.validarTime(String.valueOf(carga.getHora())) == null)
        {
            System.out.println("HoraRaw: " + carga.getHora());
            errores.put("campoErroneo", "Hora no valida: " + carga.getHora());
            errores.put("esValido", false);   
            return errores;
        }
        errores.put("campoErroneo", "");
        errores.put("esValido", true); 
        return errores;
    }


    
    public double calcularRecorrido(CargasDieselEntity carga,String ultimoOdometroStr)
    {
        double odometroUltimo = Validador.validarDouble(ultimoOdometroStr);
        double odometroActual = carga.getOdometroCarga();
        double recorrido = 0.0;

        try{
        recorrido = odometroActual - odometroUltimo;
        }catch(ArithmeticException e){
            System.out.println("Error al calcular el recorrido: " + recorrido);
        }

        return recorrido;
    }

    public double calcularRendimiento(double recorrido,double litros)
    {
        double rendimiento = 0.0;

        try{
            rendimiento = recorrido / litros;
            }catch(ArithmeticException e){
                rendimiento = 0.0;
                System.out.println("Error al calcular el recorrido: " + recorrido);
            }
            
        return rendimiento;
    }

}
