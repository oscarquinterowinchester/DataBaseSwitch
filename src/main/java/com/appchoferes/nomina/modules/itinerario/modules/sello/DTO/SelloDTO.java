package com.appchoferes.nomina.modules.itinerario.modules.sello.DTO;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelloDTO {


    private int itinerario; 

    private int chofer; 

    private String sello; 

    private String nota; 

    private String FotoSello;

}
