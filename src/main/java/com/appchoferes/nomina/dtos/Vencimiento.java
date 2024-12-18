package com.appchoferes.nomina.dtos;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Vencimiento {

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

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getVencimiento() {
    return vencimiento;
}
public void setVencimiento(String vencimiento) {
    this.vencimiento = vencimiento;
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
    this.fecha = fecha;
}
public String getDias() {
    return dias;
}
public void setDias(String dias) {
    this.dias = dias;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}




}
