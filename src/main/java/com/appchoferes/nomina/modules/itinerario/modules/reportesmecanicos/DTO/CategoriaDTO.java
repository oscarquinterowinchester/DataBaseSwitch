package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriaDTO{

    @Id
    Long id;

    String nombre;

}
