package com.PBachta.KomisApp.Entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(message = "Incorrect ID Card Number", regexp = "[A-Z]{3}[\\d]{6}")
    private String idCardNumber;
    @Pattern(message = "Incorrect PESEL number", regexp = "[\\d]{11}")
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

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
