package com.PBachta.KomisApp.entity;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.validation.FirstRegistrationDate;
import com.PBachta.KomisApp.validation.RegistrationCardIssueDate;
import com.PBachta.KomisApp.validation.RegistrationNumber;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;

@Entity
@NamedQuery(name = "find_all_cars", query = "select c from Car c")
@RegistrationCardIssueDate
public class Car {

  @Id
  @GeneratedValue
  @ApiModelProperty(notes = "Identification number")
  private Long id;

  @Enumerated
  @ApiModelProperty(notes = "Car Manufacturer")
  private Maker maker;

  @Min(50)
  @Max(6999)
  @ApiModelProperty(notes = "Capacity of the engine")
  private Integer engineCapacity;

  @Min(1)
  @Max(6)
  @ApiModelProperty(notes = "Number of seats")
  private Integer numberOfSeats;

  @FirstRegistrationDate
  @ApiModelProperty(notes = "Date of first registration")
  private Date firstRegistrationDate;

  @ApiModelProperty(notes = "Date of issuing registartion card")
  private Date registrationCardIssueDate;

  @RegistrationNumber
  @ApiModelProperty(notes = "Car registration number")
  private String registrationNumber;


  protected Car() {
  }

  public Car(Maker maker, Integer engineCapacity, Integer numberOfSeats,
             Date firstRegistrationDate, Date registrationCardIssueDate,
             String registrationNumber) {
    this.maker = maker;
    this.engineCapacity = engineCapacity;
    this.numberOfSeats = numberOfSeats;
    this.firstRegistrationDate = firstRegistrationDate;
    this.registrationCardIssueDate = registrationCardIssueDate;
    this.registrationNumber = registrationNumber;
  }

  public Car(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats,
             Date firstRegistrationDate, Date registrationCardIssueDate,
             String registrationNumber) {
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
