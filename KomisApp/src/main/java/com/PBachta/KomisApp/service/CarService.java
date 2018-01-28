package com.PBachta.KomisApp.service;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;
import com.PBachta.KomisApp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED",
                       havingValue = "false", matchIfMissing = true)
class CarService implements CarServiceInteface {

  @Autowired
  private CarRepository carRepository;


  public List<Car> getAll() {
    List<Car> carList = new ArrayList<>();

    for (Car car : carRepository.findAll()) {
      carList.add(car);
    }

    if (carList.size() == 0) {
      throw new IllegalArgumentException("There are no cars in database");
    }
    return carList;
  }


  public Car getById(Long id) {
    Car car = carRepository.findOne(id);
    if (car == null) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }
    return car;
  }


  public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats,
                  Date firstRegistrationDate, Date registrationCardIssueDate,
                  String registrationNumber) {

    Car car = new Car(maker, engineCapacity, numberOfSeats,
                      firstRegistrationDate, registrationCardIssueDate,
                      registrationNumber);
    carRepository.save(car);
    return car;
  }


  public List<Car> delete(Long id) {
    try {
      carRepository.delete(id);
    } catch (Exception e) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }
    return getAll();
  }


  public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats,
                 Date firstRegistrationDate, Date registrationCardIssueDate,
                 String registrationNumber) {
    Car car = carRepository.findOne(id);
    if (car == null) {
      throw new IllegalArgumentException("Car with id " + id + " not found");
    }

    if (maker == null)
      maker = car.getMaker();
    if (engineCapacity == null)
      engineCapacity = car.getEngineCapacity();
    if (numberOfSeats == null)
      numberOfSeats = car.getNumberOfSeats();
    if (firstRegistrationDate == null)
      firstRegistrationDate = car.getFirstRegistrationDate();
    if (registrationCardIssueDate == null)
      registrationCardIssueDate = car.getRegistrationCardIssueDate();
    if (registrationNumber == null)
      registrationNumber = car.getRegistrationNumber();

    Car updatedCar = new Car(id, maker, engineCapacity, numberOfSeats,
                             firstRegistrationDate, registrationCardIssueDate,
                             registrationNumber);

    carRepository.saveAndFlush(updatedCar);

    return carRepository.findOne(id);
  }
}
