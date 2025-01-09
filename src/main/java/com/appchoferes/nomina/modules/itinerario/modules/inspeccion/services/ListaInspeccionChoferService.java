package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.DTO.ListaInspeccionChoferDTO;
import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.repository.ListaInspeccionChoferRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;

@Service
public class ListaInspeccionChoferService {

    @Autowired
    ListaInspeccionChoferRepository listaInspeccionChoferRepository;

    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    public List<ListaInspeccionChoferDTO> getListaInspeccionByItinerario(int itinerarioId, String dbType)
            {
                utils.establecerBaseDatos(dbType);

                boolean esItinerarioInvalido =  validador.esObjetoInvalido(itinerarioId);

                if(esItinerarioInvalido)
                {
                    throw new IllegalStateException("Itinerario Invalido: ".concat(String.valueOf(itinerarioId)));
                }

                List<ListaInspeccionChoferDTO> listado = null;


                listado = listaInspeccionChoferRepository.getListaInspeccionByItinerario(itinerarioId);

                return listado;
            }

}
