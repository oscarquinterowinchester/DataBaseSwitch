package com.appchoferes.nomina.modules.itinerario.modules.combustible.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.FileStorageProperties;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.models.CargasDieselEntity;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories.CargasDieselRepository;
import com.appchoferes.nomina.operaciones.UtilsCarga;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class CargaDieselService implements ICargaDieselService {


    @Autowired
    CargasDieselRepository cargasDieselReporsitory;

    @Autowired
    Validador val;

    @Autowired
    Utils utils;

    @Autowired
    FileStorageProperties imageProps;

    public CargasDieselEntity obtenerCargaPorId(String cargaId,String dbType)
    {
        utils.establecerBaseDatos(dbType);
        return cargasDieselReporsitory.findByCargaId(Integer.parseInt(cargaId));
    
    }

    public ResponseEntity<String> procesarCarga(CargasDieselEntity carga,String dbType)
    {
        // HttpStatusCode codigoFormatoIncorrecto = HttpStatusCode.valueOf(400);
        int operacionInsercion = 0;

        utils.establecerBaseDatos(dbType);

        ResponseEntity<String> respuestaCamposValidos = UtilsCarga.revisarCampos(carga,cargasDieselReporsitory,operacionInsercion);

        // if(respuestaCamposValidos.getStatusCode() == codigoFormatoIncorrecto){

        //     return respuestaCamposValidos;
        // }
        
        String ultimoOdometro = UtilsCarga.obtenerUltimoOdometro(carga, cargasDieselReporsitory, operacionInsercion);
        carga.calcularRecorridoyRendimiento(ultimoOdometro);
       

        Map<String,String> imagenes = aislarImagenesEvidencia(carga);

        carga = setTodasFotosVacio(carga);  

        CargasDieselEntity cargaGuardada = cargasDieselReporsitory.save(carga);

        guardarImagenesCarga(cargaGuardada,imagenes);

        return respuestaCamposValidos;
    }

    private CargasDieselEntity setTodasFotosVacio(CargasDieselEntity carga){

        carga.setFotoOdometro("");
        carga.setFotoSello("");
        carga.setFotoTanque1("");
        carga.setFotoTanque2("");
        carga.setFirma("");

        return carga;

    }

    private Map<String,String> aislarImagenesEvidencia(CargasDieselEntity carga){

        Map<String,String> imagenes  = new HashMap<>();


        imagenes.put("fotoOdometro",carga.getFotoOdometro());
        imagenes.put("fotoSello",carga.getFotoSello());
        imagenes.put("fotoTanque1",carga.getFotoTanque1());
        imagenes.put("fotoTanque2",carga.getFotoTanque2());
        imagenes.put("fotoFirma",carga.getFirma());

        return imagenes;

    }
    private void guardarImagenesCarga(CargasDieselEntity carga, Map<String,String> imagenes) {

        String fotoOdometroB64 = imagenes.get("fotoOdometro");
        String fotoSelloB64 = imagenes.get("fotoSello");
        String fotoTanque1B64 = imagenes.get("fotoTanque1");
        String fotoTanque2B64 = imagenes.get("fotoTanque2");
        String fotoFirmaB64 = imagenes.get("fotoFirma");
        String nombreImg = addImgExtension(carga.getCargaId());

        

        if(Validador.objetoEsValido(fotoOdometroB64)){

            String rutaRelativa = imageProps.getFotoOdometroPath() +  nombreImg;
            
            String rutaAbsoluta = utils.saveBase64Image(fotoOdometroB64, rutaRelativa);

            carga.setFotoOdometro(rutaAbsoluta);
        }

        if(Validador.objetoEsValido(fotoSelloB64)){
            
            String rutaRelativa = imageProps.getFotoSelloPath() +  nombreImg;
            
            String rutaAbsoluta = utils.saveBase64Image(fotoSelloB64, rutaRelativa);

            carga.setFotoSello(rutaAbsoluta); 
        }

        if(Validador.objetoEsValido(fotoTanque1B64)){
          
            String rutaRelativa = imageProps.getFotoTanque1Path() +  nombreImg;
            
            String rutaAbsoluta = utils.saveBase64Image(fotoTanque1B64, rutaRelativa);

            carga.setFotoTanque1(rutaAbsoluta);    

        }

        if(Validador.objetoEsValido(fotoTanque2B64)){

            String rutaRelativa = imageProps.getFotoTanque2Path() +  nombreImg;
            
            String rutaAbsoluta = utils.saveBase64Image(fotoTanque2B64, rutaRelativa);

            carga.setFotoTanque2(rutaAbsoluta);      

        }

        if(Validador.objetoEsValido(fotoFirmaB64)){

            String rutaRelativa = imageProps.getFotoFirmaPath() +  nombreImg;
            
            String rutaAbsoluta = utils.saveBase64Image(fotoFirmaB64, rutaRelativa);

            carga.setFirma(rutaAbsoluta); 

        }

        cargasDieselReporsitory.save(carga);

    }

    private String addImgExtension(Object nombreImgObj){

        String nombreImg = Validador.toStr(nombreImgObj);
        String imgConExtension = "";

        if(Validador.objetoNoEsValido(nombreImg)){
            return "";
        }

        imgConExtension = nombreImg + imageProps.getImageExtension();

        return imgConExtension;
    }
    

    public ResponseEntity<String> actualizarCargaPorCampos(String cargaId, Map<String, Object> campos, String dbType) {
        
        Map<String,Object> errores = null;
        int cargaIdInt = Validador.validarInteger(cargaId); 
        int operacionActualizar = 1;

        if(cargaIdInt <= 0)
        {
            return ResponseEntity.badRequest().body("Error en formato, cargaId no valida");
        }

        utils.establecerBaseDatos(dbType);

        CargasDieselEntity cargaExistente = cargasDieselReporsitory.findByCargaId(cargaIdInt);

        cargaExistente = UtilsCarga.asignarDatosDeCarga(campos, cargaExistente);

        errores = UtilsCarga.datosCargaSonValidos(cargaExistente,cargasDieselReporsitory,operacionActualizar);

        Boolean campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));
        String mensajeError = "Error en los formatos: "+ errores.get("campoErroneo");

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body(mensajeError); // Invalid data
        }

        String ultimoOdometro = UtilsCarga.obtenerUltimoOdometro(cargaExistente, cargasDieselReporsitory, operacionActualizar);
        cargaExistente.calcularRecorridoyRendimiento(ultimoOdometro);
        
        cargasDieselReporsitory.save(cargaExistente);
    
        return ResponseEntity.ok("Actualizado con exito"); // Retornar la entidad actualizada
    }

    
    


}
