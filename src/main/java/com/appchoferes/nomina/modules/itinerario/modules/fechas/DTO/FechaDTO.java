package com.appchoferes.nomina.modules.itinerario.modules.fechas.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FechaDTO {

    @JsonProperty("eventoWCID")
    private int eventoWCID;

    @JsonProperty("itinerarioID")
    private int itinerarioId;

    @JsonProperty("fechaEvento")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaEvento;

    @JsonProperty("Fecha")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;

    @Override
    public String toString() {
        return "FechaDTO [eventoWCID=" + eventoWCID + ", itinerarioId=" + itinerarioId + ", fechaEvento=" + fechaEvento
                + ", fecha=" + fecha + "]";
    }

}
