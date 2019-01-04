package com.PBachta.KomisApp.service;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;

import java.sql.Date;
import java.util.List;

public interface CarServiceInteface {

  List<Car> getAll();

  Car getById(Long id);

  Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats,
           Date firstRegistrationDate, Date registrationCardIssueDate,
           String registrationNumber);

  List<Car> delete(Long id);

  Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats,
          Date firstRegistrationDate, Date registrationCardIssueDate,
          String registrationNumber);
}
