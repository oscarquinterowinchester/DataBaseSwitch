package com.appchoferes.nomina.modules.vencimiento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class VencimientoEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id") 
Long id;

@Column(name = "expiration") 
String vencimiento;

@Column(name = "date") 
String fecha;

@Column(name = "days") 
String dias;

@Column(name = "status") 
String status;

}
