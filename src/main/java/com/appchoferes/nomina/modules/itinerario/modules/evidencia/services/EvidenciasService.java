package com.appchoferes.nomina.modules.itinerario.modules.evidencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.FileStorageProperties;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.TipoEvidenciaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.models.EvidenciasEntity;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories.EvidenciasRepository;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories.TipoEvidenciaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.requests.DTO.EvidenciasDTO;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;


@Service
public class EvidenciasService {

    @Autowired
    EvidenciasRepository evidenciasRepository;

    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    @Autowired
    FileStorageProperties imageProps;

    @Autowired
    TipoEvidenciaRepository tipoEvidenciaRepo;



    public List<TipoEvidenciaDTO> getTipoEvidencias(String dbType)
    {

        utils.establecerBaseDatos(dbType);

        return tipoEvidenciaRepo.getTipoEvidencias();

    }

    public String guardarEvidencias(EvidenciasDTO evidencia, String dbType){

        utils.establecerBaseDatos(dbType);
        
        EvidenciasEntity evidenciasEntity = getDatosEvidenciaDTO(evidencia);

        Long evidenciaId = saveEvidencias(evidenciasEntity, dbType); // guarda datos y obtiene el id

        String rutaAbsoluta = guardarImagenSistema(String.valueOf(evidenciaId),evidencia);

        setRutaImagenEvidencia(evidenciaId,rutaAbsoluta);

        return "";

    }

    private void setRutaImagenEvidencia(Long fileId,String rutaAbsoluta){

        if(validador.esObjetoInvalido(rutaAbsoluta)){

          return;
        }
        if(validador.esObjetoInvalido(fileId)){

            utils.throwRunTimeException("fileId vacio");
          }

        EvidenciasEntity evidencia = evidenciasRepository.getEvidenciasEntityByFileId(fileId);

        String nombre = fileId + imageProps.getImageExtension();
        String archivo = String.valueOf(fileId);

        evidencia.setNombre(nombre);
        evidencia.setArchivo(archivo);
        evidencia.setAPath(rutaAbsoluta);

        evidenciasRepository.save(evidencia);

    }

    private String guardarImagenSistema(String evidenciaId,EvidenciasDTO evidencia){

        // Guardar la imagen.
        String imgBase64 = getImagenEvidencia(evidencia);

        String rutaRelativa = getRutaRelativa(evidenciaId);
            
        String rutaAbsoluta = utils.saveBase64Image(imgBase64, rutaRelativa);

        return rutaAbsoluta;

    }

    private String getRutaRelativa(String nombreImg){

       return imageProps.getEvidenciaPath() + nombreImg + imageProps.getImageExtension();

    }

    private String getImagenEvidencia(EvidenciasDTO evidencia){
        try 
        {
            if(validador.esObjetoInvalido(evidencia.getFotos().get(0)))
         {
            return "";
         }

         return evidencia.getFotos().get(0);

         
        } catch (Exception e) {
            throw new NullPointerException("Error al obtener imagen de evidencia DTO");
        }

    }
    private Long saveEvidencias(EvidenciasEntity evidenciasEntity,String dbType){

        utils.establecerBaseDatos(dbType);
        Long registroId;

        try{
            EvidenciasEntity registroGuardado =  evidenciasRepository.save(evidenciasEntity);
            registroId = registroGuardado.getFileId();
        }catch(NullPointerException e){
            throw new NullPointerException("Error al guardar evidencia en la base de datos");
        }
        return registroId;

    }

    private EvidenciasEntity getDatosEvidenciaDTO(EvidenciasDTO evidencia){


        if(validador.esObjetoInvalido(evidencia)){
            throw new IllegalArgumentException("Evidencias es nulo");
        }

        EvidenciasEntity evidenciasEntity = new EvidenciasEntity();
        
        evidenciasEntity.setItinerarioId(evidencia.getItinerarioId());
        evidenciasEntity.setWContId(evidencia.getWContId());
        evidenciasEntity.setEvidenciaId(evidencia.getEvidenciaId());
        evidenciasEntity.setExtension(imageProps.getImageExtension());
        evidenciasEntity.setWContId(evidenciasRepository.getWContIdByItinerarioId(evidencia.getItinerarioId()));

        return evidenciasEntity;
    }

    

}
