package com.appchoferes.nomina.modules.itinerario.modules.extra.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.FileStorageProperties;
import com.appchoferes.nomina.modules.itinerario.modules.extra.DTO.ExtraRequestDTO;
import com.appchoferes.nomina.modules.itinerario.modules.extra.models.CajaChicaEntity;
import com.appchoferes.nomina.modules.itinerario.modules.extra.repositories.CajaChicaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.RevisionDTO;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class CajaChicaService {



    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    @Autowired
    FileStorageProperties imageProps;

    @Autowired
    CajaChicaRepository cajaChicaRepository;
    


    public List<Map<String, Object>> getConceptos( String dbType){

        utils.establecerBaseDatos(dbType);

        return cajaChicaRepository.findConceptosActivos();
}

    public int eliminarCajaChica(int cajaId, String dbType){

        utils.establecerBaseDatos(dbType);

        return cajaChicaRepository.deleteByCajaId(cajaId);
}

    public int guardarCajaChica(ExtraRequestDTO extraRequestDTO, String dbType){

            utils.establecerBaseDatos(dbType);

            int cajaChicaSavedId = procesarGuardadoCajaChica(extraRequestDTO);

            mandarDatosExtraCajaChica( extraRequestDTO,  cajaChicaSavedId);

            return cajaChicaSavedId;
    }
        
        private void mandarDatosExtraCajaChica(ExtraRequestDTO extraRequestDTO, int cajaChicaSavedId) {

            Map<String,Object> datosExtra = obtenerDatosExtraCajaChica( extraRequestDTO,  cajaChicaSavedId);

            CajaChicaEntity cajaChica = cajaChicaRepository.getCajaChicaEntityByCajaChicaId(cajaChicaSavedId);

            cajaChica.setPathFile(Validador.toStr(datosExtra.get("pathfile")));
            cajaChica.setImporte(validador.toFloat(cajaChica));
            cajaChica.setMoneda(validador.toInt(datosExtra.get("moneda")));
            cajaChica.setUnitario(validador.toFloat(datosExtra.get("unitario")));
            cajaChica.setFecha(LocalDateTime.now().minusHours(8));
            cajaChica.setImporteOriginal(validador.toFloat(datosExtra.get("importeOriginal")));


            cajaChicaRepository.save(cajaChica);

        }
        
        private Map<String,Object> obtenerDatosExtraCajaChica(ExtraRequestDTO extraRequestDTO, int cajaChicaSavedId){

        Map<String,Object> datosExtra = new HashMap<>();

        String rutaAbsolutaImg = procesarImagenesFirma(cajaChicaSavedId,extraRequestDTO);

        float importe = cajaChicaRepository.getPagoExtraDin(cajaChicaSavedId);
        int moneda = cajaChicaRepository.getMonedaPagoExtraDin(cajaChicaSavedId);

        datosExtra.put("pathfile", rutaAbsolutaImg);
        datosExtra.put("importe", extraRequestDTO.getCantidad() * importe);
        datosExtra.put("moneda", moneda);
        datosExtra.put("unitario", importe);
        datosExtra.put("fecha", LocalDateTime.now());
        datosExtra.put("importeOriginal", extraRequestDTO.getCantidad() * importe);

        return datosExtra;

    }

    public Integer procesarGuardadoCajaChica(ExtraRequestDTO extraRequestDTO){

        CajaChicaEntity cajaChicaEntity =  deserealizarDTO(extraRequestDTO);

        CajaChicaEntity cajaChicaSaved = cajaChicaRepository.save(cajaChicaEntity);

        return cajaChicaSaved.getCajaChicaId();
    }

        private String procesarImagenesFirma(int cajaChicaSavedId, ExtraRequestDTO ExtraRequestDTO) {
        

        String firmaChoferB64 = getImagenEvidencia(ExtraRequestDTO);

        String rutaRelativaChofer = getRutaRelativa(Validador.toStr(cajaChicaSavedId));

            
        String rutaAbsolutaChofer = utils.saveBase64Image(firmaChoferB64, rutaRelativaChofer);


        return rutaAbsolutaChofer;

    }

    private String getRutaRelativa(String nombreImg){


        return imageProps.getExtrasPath()+ nombreImg + imageProps.getImageExtension();
    }
 

    private String getImagenEvidencia(ExtraRequestDTO ExtraRequestDTO){
        try 
        {

        String imagenB64 = "";

        imagenB64 = ExtraRequestDTO.getFoto();

         if(validador.esObjetoInvalido(imagenB64))
         {
            return "";
         }

         return imagenB64;

         
        } catch (Exception e) {
            throw new NullPointerException("Error al obtener imagen de revision DTO");
        }

    }


    public CajaChicaEntity deserealizarDTO(ExtraRequestDTO extraRequestDTO){


        CajaChicaEntity cajaChicaEntity = CajaChicaEntity.builder()
        .cajaChicaId(extraRequestDTO.getCajachicaID())
        .cantidad(extraRequestDTO.getCantidad())
        .descripcion(extraRequestDTO.getCargo().getNombre())
        .itinerarioId(extraRequestDTO.getItinerarioId())
        .cargoId(extraRequestDTO.getCargo().getId())
        .usuarioId(extraRequestDTO.getChoferId())
        .movimiento(1)
        .status(true)
        .referencia(extraRequestDTO.getDescripcion())
        .fecha(LocalDateTime.now().minusHours(8))
        .build();

        return cajaChicaEntity;
    }

    public List<CajaChicaEntity> getExtrasByItinerarioId(int itinerarioId, String dbType) {
        
        utils.establecerBaseDatos(dbType);

       return cajaChicaRepository.findByItinerarioId(itinerarioId);
    }


}
