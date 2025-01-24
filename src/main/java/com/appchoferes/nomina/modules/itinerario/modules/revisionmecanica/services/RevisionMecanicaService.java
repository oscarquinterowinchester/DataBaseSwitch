package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.FileStorageProperties;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.InspeccionMecanicaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.PuntosRevisionDTO;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.RevisionDTO;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.models.PuntosRevisionEntity;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.models.RevisionMecanicaEntity;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.repositories.PuntosRevisionMecanicaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.repositories.PuntosRevisionRepository;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.repositories.RevisionMecanicaRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class RevisionMecanicaService {


    @Autowired
    PuntosRevisionRepository Puntosrepository;

    @Autowired
    RevisionMecanicaRepository revisionMecanicaRepository;

    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    @Autowired
    FileStorageProperties imageProps;

    @Autowired
    PuntosRevisionMecanicaRepository PuntosRevisionMecanicaRepository;

    public List<PuntosRevisionDTO> getPuntosRevision(String dbType){

        if(validador.esObjetoInvalido(dbType)){

            List<PuntosRevisionDTO> listaVacia = new ArrayList<>();
            return listaVacia;
        }

        utils.establecerBaseDatos(dbType);

        return Puntosrepository.getPuntosRevision();
    }

    public String saveRevisionMecanica(RevisionDTO revisionDTO, String dbType) {
        
        utils.establecerBaseDatos(dbType);

        procesarGuardado(revisionDTO);

        return "Guardado procesado";
    }

    public void procesarGuardado(RevisionDTO revisionDTO)
    {
    
    Long revisionMecanicaId =  procesarRevisionMecanica(revisionDTO);

     procesarPuntosRevision(revisionDTO,Integer.parseInt(Validador.toStr(revisionMecanicaId)));
              
    }

    private void procesarPuntosRevision(RevisionDTO revisionDTO, int revisionId){

      List<PuntosRevisionDTO> puntos =  revisionDTO.getPuntosRevision();

      for(PuntosRevisionDTO punto : puntos){

        PuntosRevisionEntity revisionPuntosMecanicos = PuntosRevisionEntity.builder()
        .check(punto.isCheck())
        .fecha(LocalDateTime.now().minusHours(8))
        .revisionMecanicaId(Integer.parseInt(Validador.toStr(punto.getId())))
        .revisionMecanicaPuntosId(revisionId).build();


        System.out.println(revisionPuntosMecanicos.toString());

        PuntosRevisionMecanicaRepository.save(revisionPuntosMecanicos);
      }

    }

    private Long procesarRevisionMecanica(RevisionDTO revisionDTO){

    InspeccionMecanicaDTO InspeccionMecanicaDTO = revisionDTO.getRevision();

    RevisionMecanicaEntity revision = deserealizarRevisionDTO(InspeccionMecanicaDTO);

    Long revisionISaved =  guardarRevisionEntity(revision);

    Map<String,String> firmasRutas =  procesarImagenesFirma(revisionISaved,revisionDTO);
    
    guardarEnRevisionRutasImg(revisionISaved,firmasRutas);

    return revisionISaved;

    }
        
    private void guardarEnRevisionRutasImg(Long revisionISaved, Map<String,String> firmasRutas) {

     RevisionMecanicaEntity revision = revisionMecanicaRepository.findById(revisionISaved).orElseThrow();

     revision.setFirma(firmasRutas.get("rutaAbsolutaChofer"));
     revision.setFirmaMecanico(firmasRutas.get("rutaAbsolutaMecanico"));

     revisionMecanicaRepository.save(revision);
       
    }
        
    private RevisionMecanicaEntity deserealizarRevisionDTO(InspeccionMecanicaDTO inspeccionMecanicaDTO){

        RevisionMecanicaEntity revision =  RevisionMecanicaEntity.builder().
        choferId(inspeccionMecanicaDTO.getChoferId())
        .defects(inspeccionMecanicaDTO.isDefects())
        .fecha(LocalDateTime.now())
        .itinerarioId(inspeccionMecanicaDTO.getItinerarioId())
        .safety(inspeccionMecanicaDTO.isSafety())
        .satisfactory(inspeccionMecanicaDTO.isSatisfactory())
        .remark(inspeccionMecanicaDTO.getRemark()).build();

        return revision;
    }
      
    private Map<String,String> procesarImagenesFirma(Long revisionISaved, RevisionDTO revisionDTO) {
        
        boolean esParaChofer = true, esParaMecanico = false;

        String firmaChoferB64 = getImagenEvidencia(revisionDTO,esParaChofer);
        String firmaMecanicoB64 = getImagenEvidencia(revisionDTO,esParaMecanico);

        String rutaRelativaChofer = getRutaRelativa(Validador.toStr(revisionISaved),esParaChofer);
        String rutaRelativaMecanico = getRutaRelativa(Validador.toStr(revisionISaved),esParaMecanico);

            
        String rutaAbsolutaChofer = utils.saveBase64Image(firmaChoferB64, rutaRelativaChofer);
        String rutaAbsolutaMecanico = utils.saveBase64Image(firmaMecanicoB64, rutaRelativaMecanico);

        Map<String,String> firmasRutas = new HashMap<>();

        firmasRutas.put("rutaAbsolutaChofer", rutaAbsolutaChofer);
        firmasRutas.put("rutaAbsolutaMecanico", rutaAbsolutaMecanico);

        return firmasRutas;

    }


    private String getRutaRelativa(String nombreImg,boolean esChofer){

        String sufijo = "";

        if(esChofer){

            sufijo = "_chofer";
        }else{
            sufijo = "_mecanico";
        }

        return imageProps.getFirmasPath() + nombreImg + sufijo + imageProps.getImageExtension();
 
     }

        private String getImagenEvidencia(RevisionDTO revisionDTO,boolean esFirmaChofer){
        try 
        {

        String imagenB64 = "";

        if(esFirmaChofer){
            imagenB64 = revisionDTO.getRevision().getFirma();
        }else{
            imagenB64 = revisionDTO.getRevision().getFirmaMecanico();  
        }

         if(validador.esObjetoInvalido(imagenB64))
         {
            return "";
         }

         return imagenB64;

         
        } catch (Exception e) {
            throw new NullPointerException("Error al obtener imagen de revision DTO");
        }

    }

          private Long guardarRevisionEntity(RevisionMecanicaEntity revision){

        RevisionMecanicaEntity revisionSaved =  revisionMecanicaRepository.save(revision);

        return revisionSaved.getId();

    }

}
