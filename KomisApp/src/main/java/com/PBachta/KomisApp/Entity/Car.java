package com.PBachta.KomisApp.Entity;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Validation.IsCorrectCar;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IsCorrectCar
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private Maker maker;
    private Integer engineCapacity;
    private Integer numberOfSeats;
    private String firstRegistrationDate;
    private String registrationCardIssueDate;
    private String registrationNumber;


    protected Car(){}

    public Car(Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber ) {
        this.maker = maker;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
        this.firstRegistrationDate = firstRegistrationDate;
        this.registrationCardIssueDate = registrationCardIssueDate;
        this.registrationNumber = registrationNumber;
    }

    public Car(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber){
        this.id = id;
        this.maker = maker;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
        this.firstRegistrationDate = firstRegistrationDate;
        this.registrationCardIssueDate = registrationCardIssueDate;
        this.registrationNumber = registrationNumber;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(String firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getRegistrationCardIssueDate() {
        return registrationCardIssueDate;
    }

    public void setRegistrationCardIssueDate(String registrationCardIssueDate) {
        this.registrationCardIssueDate = registrationCardIssueDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}