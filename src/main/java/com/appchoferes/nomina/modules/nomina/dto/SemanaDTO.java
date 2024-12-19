package com.appchoferes.nomina.modules.nomina.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Embeddable
public class SemanaDTO{

    @Id
    private Long id;

    private String fechaIni;

    private String fechaFin;


}
