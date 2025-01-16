package com.appchoferes.nomina.modules.itinerario.modules.sello.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.itinerario.modules.sello.models.SelloEntity;

@Service
public interface ISelloService {

    public List<SelloEntity> getSellosByItinerarioId(int itinerarioId, String dbType);

}
