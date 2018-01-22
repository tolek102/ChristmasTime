package com.PBachta.KomisApp.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Identification number")
    private Long id;

    @Size(min = 3, max = 30)
    @ApiModelProperty(notes = "Customer first name")
    private String firstName;

    @Size(min = 3, max = 30)
    @ApiModelProperty(notes = "Customer last name")
    private String lastName;

    @Pattern(message = "Incorrect ID Card Number [example: ABC123456]", regexp = "[A-Z]{3}[\\d]{6}")
    @ApiModelProperty(notes = "ID card number of customer")
    private String idCardNumber;

    @Pattern(message = "Incorrect PESEL number - 11 chars, digits only is expected", regexp = "[\\d]{11}")
    @ApiModelProperty(notes = "PESEL number of customer")
    private String peselNumber;


    protected Customer() {
    }

    public Customer(String firstName, String lastName, String idCardNumber, String peselNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCardNumber = idCardNumber;
        this.peselNumber = peselNumber;
    }

    public Customer(Long id, String firstName, String lastName, String idCardNumber, String peselNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCardNumber = idCardNumber;
        this.peselNumber = peselNumber;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
