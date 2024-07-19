package com.appchoferes.app.dtos;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vencimiento {
@Id
Long id;
String expiration;
String date;
String days;
String status;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getExpiration() {
    return expiration;
}
public void setExpiration(String expiration) {
    this.expiration = expiration;
}
public String getDate() {
    return date;
}
public void setDate(String date) {
    this.date = date;
}
public String getDays() {
    return days;
}
public void setDays(String days) {
    this.days = days;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}




}
