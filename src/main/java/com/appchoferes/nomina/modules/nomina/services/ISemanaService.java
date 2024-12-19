package com.appchoferes.nomina.modules.nomina.services;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.nomina.dto.SemanaDTO;

@Service
public interface ISemanaService {
    
    public SemanaDTO getFechaIniyFin(String dbType, String semanaId);

}
