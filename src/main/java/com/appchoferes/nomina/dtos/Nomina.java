package com.appchoferes.nomina.dtos;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Nomina {
    @Id
    Long id;
    String route;
    String date;
    Integer payment;
    String container;
    Integer truck;
    Integer amount;
    Integer status;


    @Transient
    ArrayList<Extras> extras;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getPayment() {
        return payment;
    }
    public void setPayment(Integer payment) {
        this.payment = payment;
    }
    public String getContainer() {
        return container;
    }
    public void setContainer(String container) {
        this.container = container;
    }
    public Integer getTruck() {
        return truck;
    }
    public void setTruck(Integer truck) {
        this.truck = truck;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public ArrayList<Extras> getExtras() {
        return extras;
    }
    public void setExtras( ArrayList<Extras> extras) {
        this.extras = extras;
    }
}
