package com.appchoferes.nomina.dtos;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nomina {
    @Id
    @Column(name = "id")
    Long itinerarioId;

    @Column(name = "route")
    String ruta;

    @Column(name = "date")
    String fechaCarga;

    @Column(name = "payment")
    Integer pago;

    @Column(name = "container")
    String contenedor;

    @Column(name = "truck")
    Integer noEcoCamion;

    @Column(name = "amount")
    Integer totalPago;

    @Column(name = "status")
    String estadoViaje;

    @Column(name = "estatusViaje")
    int status;

    @Column(name = "estadoCarga")
    String estadoCarga;
    

    @Transient
    ArrayList<Extras> extras;

    // public Long getId() {
    //     return id;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }
    // public String getRoute() {
    //     return route;
    // }
    // public void setRoute(String route) {
    //     this.route = route;
    // }
    // public String getDate() {
    //     return date;
    // }
    // public void setDate(String date) {
    //     this.date = date;
    // }
    // public Integer getPayment() {
    //     return payment;
    // }
    // public void setPayment(Integer payment) {
    //     this.payment = payment;
    // }
    // public String getContainer() {
    //     return container;
    // }
    // public void setContainer(String container) {
    //     this.container = container;
    // }
    // public Integer getTruck() {
    //     return truck;
    // }
    // public void setTruck(Integer truck) {
    //     this.truck = truck;
    // }
    // public Integer getAmount() {
    //     return amount;
    // }
    // public void setAmount(Integer amount) {
    //     this.amount = amount;
    // }
    // public String getStatus() {
    //     return status;
    // }
    // public void setStatus(String status) {
    //     this.status = status;
    // }
    // public ArrayList<Extras> getExtras() {
    //     return extras;
    // }
    // public void setExtras( ArrayList<Extras> extras) {
    //     this.extras = extras;
    // }

}
