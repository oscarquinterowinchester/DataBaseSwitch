package com.appchoferes.nomina.modules.vencimiento.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.modules.vencimiento.models.VencimientoEntity;

@Service
public interface IVencimientoService {

    public List<VencimientoEntity> getVencimiento(String choferId,String dbType);
    
}

