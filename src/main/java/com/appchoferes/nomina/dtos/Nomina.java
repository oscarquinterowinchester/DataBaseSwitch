package com.appchoferes.nomina.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Nomina {
    @Id
    Long id;
    String route;
    String date;
    Integer payment;
    Integer container;
    Integer truck;
    Integer amount;
    Integer status;

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
    public Integer getContainer() {
        return container;
    }
    public void setContainer(Integer container) {
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

    
}
