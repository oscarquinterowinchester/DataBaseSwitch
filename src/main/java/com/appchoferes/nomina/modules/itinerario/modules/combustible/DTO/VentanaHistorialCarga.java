package com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO;

import java.util.List;

import jakarta.persistence.ElementCollection;
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
    
    @ElementCollection
    List<CargasHistorialPrevio> historial;

}
