package com.PBachta.KomisApp.Entity;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Validation.IsCorrectCar;

import javax.persistence.*;
import java.sql.Date;


@Entity
@NamedQuery(name = "find_all_cars", query = "select c from Car c")
@IsCorrectCar
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated
    private Maker maker;
    private Integer engineCapacity;
    private Integer numberOfSeats;
    private Date firstRegistrationDate;
    private Date registrationCardIssueDate;
    private String registrationNumber;


    protected Car() {
    }

    public Car(Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {
        this.maker = maker;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
        this.firstRegistrationDate = firstRegistrationDate;
        this.registrationCardIssueDate = registrationCardIssueDate;
        this.registrationNumber = registrationNumber;
    }

    public Car(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {
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

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public Date getRegistrationCardIssueDate() {
        return registrationCardIssueDate;
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