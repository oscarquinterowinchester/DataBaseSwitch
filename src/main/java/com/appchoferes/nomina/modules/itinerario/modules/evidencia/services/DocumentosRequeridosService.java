package com.appchoferes.nomina.modules.itinerario.modules.evidencia.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.DocumentosRequeridosDTO;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.EvidenciasSubidasDTO;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories.DocumentosRequeridosRepository;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories.EvidenciasRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class DocumentosRequeridosService {
    
    @Autowired
    DocumentosRequeridosRepository docsRequeridosRepo;

    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    @Autowired
    EvidenciasRepository evidenciasRepository;



    public EvidenciasSubidasDTO getDocumentosRequeridosyEvidencias(String dbType,int itinerarioId){

        utils.establecerBaseDatos(dbType);
        
        EvidenciasSubidasDTO evidencias = new EvidenciasSubidasDTO();

        evidencias.setExtras(evidenciasRepository.getEvidenciasByItinerarioId(itinerarioId)); // Lista de extras

        //Falta obligatoria
        evidencias.setObligatorias(getDocumentosRequeridos(dbType,itinerarioId));

        
        return evidencias;
    }

    public ArrayList<DocumentosRequeridosDTO> getDocumentosRequeridos(String dbType,int itinerarioId){
        
        utils.establecerBaseDatos(dbType);

       String documentosObtenidos = docsRequeridosRepo.getDocumentosRequeridos(itinerarioId);

       String[] documentosArray = documentosObtenidos.split(",");

       ArrayList<DocumentosRequeridosDTO> documentosLista = new ArrayList<>();

       Long iteracionNum = 1L;

       for(String nombreDoc : documentosArray){

        DocumentosRequeridosDTO doc = new DocumentosRequeridosDTO();

        if(validador.esObjetoInvalido(nombreDoc))
        {
            continue;
        }
        
        doc.setNombre(nombreDoc);
        doc.setEvidenciaItiId(iteracionNum);

        iteracionNum+=1;

        documentosLista.add(doc);

       }

        return documentosLista;
    }





}
