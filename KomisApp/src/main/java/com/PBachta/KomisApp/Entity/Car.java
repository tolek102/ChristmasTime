package com.PBachta.KomisApp.Entity;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Validation.IsCorrectCar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;


@Entity
@NamedQuery(name = "find_all_cars", query = "select c from Car c")
@IsCorrectCar
public class Car {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Identification number")
    private Long id;

    @Enumerated
    @ApiModelProperty(notes = "Car Manufacturer")
    private Maker maker;

    @ApiModelProperty(notes = "Capacity of the engine")
    private Integer engineCapacity;

    @ApiModelProperty(notes = "Number of seats")
    private Integer numberOfSeats;

    @ApiModelProperty(notes = "Date of first registration")
    private Date firstRegistrationDate;

    @ApiModelProperty(notes = "Date of issuing registartion card")
    private Date registrationCardIssueDate;

    @ApiModelProperty(notes = "Car registration number")
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

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Date getRegistrationCardIssueDate() {
        return registrationCardIssueDate;
    }

    public void setRegistrationCardIssueDate(Date registrationCardIssueDate) {
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