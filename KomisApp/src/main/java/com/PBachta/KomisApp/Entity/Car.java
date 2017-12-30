package com.PBachta.KomisApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String maker;
    private String model;
    private String registrationNumber;
    private String vinNumber;

    protected Car(){}

    public Car(String maker, String model, String registrationNumber, String vinNumber) {
        this.maker = maker;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
    }

    public Car(long id, String maker, String model, String registrationNumber, String vinNumber){
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registraionNumber) {
        this.registrationNumber = registraionNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}