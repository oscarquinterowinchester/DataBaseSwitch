package com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventosItinerarioDTO {


    @Id
    private Long EventoWCID;
    
    private int WContFK;
    
    private int ItinerarioID;
    
    private int EventoID;
    
    private int OrdenWC;
    
    private String Concepto;
    
    private boolean Validado;
    
    private LocalDateTime FechaEvento;
    
    private boolean esrojo;

    private boolean essalida;

    private boolean esllegada;


}
