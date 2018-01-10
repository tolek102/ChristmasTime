package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(prefix = "", name = "H2_STORAGE_ENABLED", havingValue="false")
class CarService implements CarServiceInteface {


    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();

        carList.addAll(carRepository.findAll());

        if (carList.size() == 0) {
            throw new RuntimeException("There are no cars in database");
        }
        return carList;
    }


    public Car getById(Long id) {
        Car car = carRepository.findOne(id);
        if (car == null) {
            throw new RuntimeException("Car with id "+id+" not found");
        }
        return car;
    }


    public Car post(Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {

        Car car = new Car(maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
        carRepository.save(car);
        return car;
    }


    public List<Car> delete(Long id) {
        carRepository.delete(id);
        return getAll();
    }


    public Car put(Long id, Maker maker, Integer engineCapacity, Integer numberOfSeats, Date firstRegistrationDate, Date registrationCardIssueDate, String registrationNumber) {
        Car car = carRepository.findOne(id);
        if (car == null) {
            throw new RuntimeException("Car with id "+id+" not found");
        }

        if(maker == null)
            maker = car.getMaker();
        if(engineCapacity == null)
            engineCapacity = car.getEngineCapacity();
        if(numberOfSeats == null)
            numberOfSeats = car.getNumberOfSeats();
        if (firstRegistrationDate == null)
            firstRegistrationDate = car.getFirstRegistrationDate();
        if (registrationCardIssueDate == null)
            registrationCardIssueDate = car.getRegistrationCardIssueDate();
        if (registrationNumber == null)
            registrationNumber = car.getRegistrationNumber();

        Car updatedCar = new Car(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
        carRepository.save(updatedCar);
        return carRepository.findOne(id);
    }


//______________________________________________ additional functions___________________________________________________


//    public List<Car> getByMaker(Maker maker) {
//        List<Car> carList = new ArrayList<>();
//        for(Car car : carRepository.findByMaker(maker)){
//            carList.add(car);
//        }
//
//        if (carList.size() == 0) {
//            throw new RuntimeException("Car with maker "+maker+" not found");
//        }
//        return carList;
//    }
//
//
//    public List<Car> getByModel(String model) {
//        List<Car> carList = new ArrayList<>();
//        for(Car car : carRepository.findByEngineCapacity(model)){
//            carList.add(car);
//        }
//
//        if (carList.size() == 0) {
//            throw new RuntimeException("Car with model "+model+" not found");
//        }
//        return carList;
//    }
//
//
//    public Car getByVinNumber(String vinNumber) {
//        Car car = carRepository.findByVinNumber(vinNumber);
//        if (car == null) {
//            throw new RuntimeException("Car with VIN number "+vinNumber+" not found");
//        }
//        return car;
//    }
//
//
//    public Car getByRegistrationNumber(String registrationNumber) {
//        Car car = carRepository.findByRegistrationNumber(registrationNumber);
//        if (car == null) {
//            throw new RuntimeException("Car with registration number "+registrationNumber+" not found");
//        }
//        return car;
//    }
}
