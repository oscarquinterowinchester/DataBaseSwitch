package com.appchoferes.nomina.modules.itinerario.modules.sello.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.appchoferes.nomina.config.FileStorageProperties;
import com.appchoferes.nomina.modules.itinerario.modules.sello.DTO.SelloDTO;
import com.appchoferes.nomina.modules.itinerario.modules.sello.DTO.SelloRotoDTO;
import com.appchoferes.nomina.modules.itinerario.modules.sello.models.SelloEntity;
import com.appchoferes.nomina.modules.itinerario.modules.sello.repositories.SelloRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class SelloServiceImpl implements ISelloService{

    @Autowired
    Utils utils;

    @Autowired
    SelloRepository selloRepository;

    @Autowired
    FileStorageProperties fileStorage;

    @Autowired
    Validador validador;
    


    @Override
    public List<SelloEntity> getSellosByItinerarioId(int itinerarioId, String dbType) {

        utils.establecerBaseDatos(dbType);

        return  selloRepository.getSellosByItinerarioId(itinerarioId);
         
    }


    public void romperSello( SelloRotoDTO selloDTO, String dbType){

     try {
            
        utils.establecerBaseDatos(dbType);

        if(validador.esObjetoInvalido(selloDTO)){
            return;
        }
    
        int selloId = selloDTO.getSelloId();

        selloRepository.romperSello(selloId);
    } catch (NullPointerException e) {
        
    }

    }

    
public String guardarSellos(SelloDTO selloDTO, String dbType){


    utils.establecerBaseDatos(dbType);

    SelloEntity selloEntity = deserealizarSello(selloDTO,dbType);

    SelloEntity selloEntitySaved  = selloRepository.save(selloEntity);

    if(selloEntitySaved == null){

        return "Error al guardar";
    }

    guardarImagen(selloDTO,selloEntitySaved,dbType);

    return "guardado con exito";
}

private void guardarImagen(SelloDTO selloDTO,SelloEntity selloEntitySaved,String dbType){

    try {
    
    utils.establecerBaseDatos(dbType);

    String fotoSello = selloDTO.getFotoSello();

    String rutaAbsoluta = "";

    if(validador.esObjetoValido(fotoSello)){
        rutaAbsoluta = utils.saveBase64Image(fotoSello,fileStorage.getSelloPath()+selloEntitySaved.getSelloId()+fileStorage.getImageExtension());
    }

    selloEntitySaved.setFotoSello(rutaAbsoluta);
    selloEntitySaved.setFotoSelloLiga(rutaAbsoluta);

    selloRepository.save(selloEntitySaved);
} catch (Exception e) {
    throw new NullPointerException();
}

}

private SelloEntity deserealizarSello(SelloDTO selloDTO, String dbType){

    utils.establecerBaseDatos(dbType);

    int clienteId = selloRepository.getClienteSelloByItinearioId(selloDTO.getItinerario());

   return SelloEntity.builder()
    .clienteId(clienteId)
    .usuarioFk(selloDTO.getChofer())
    .itinerarioId(selloDTO.getItinerario())
    .sello(selloDTO.getSello())
    .nota(selloDTO.getNota())
    .status(true)
    .enUso(true)
    .fecha(LocalDateTime.now().minusHours(8))
    .build();

}


}
