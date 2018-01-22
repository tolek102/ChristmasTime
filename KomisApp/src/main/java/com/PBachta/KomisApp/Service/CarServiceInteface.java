package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;

import java.sql.Date;
import java.util.List;

public interface CarServiceInteface {

    List<Car> getAll();

    Car getById(Long id);

    Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber);

    List<Car> delete(Long id);

    Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber);
}
