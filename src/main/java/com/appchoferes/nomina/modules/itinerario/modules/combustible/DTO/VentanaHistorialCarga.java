package com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentanaHistorialCarga {

    CamionesConCargaDTO camion;
    
    List<Object []> historial;

}
