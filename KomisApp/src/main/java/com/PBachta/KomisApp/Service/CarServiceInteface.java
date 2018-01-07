package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;

import java.util.List;

public interface CarServiceInteface {

    List<Car> getAll();

    Car getById(Long id);

    Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber);

    List<Car> delete(Long id);

    Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, String firstRegistrationDate, String registrationCardIssueDate, String registrationNumber);
}
