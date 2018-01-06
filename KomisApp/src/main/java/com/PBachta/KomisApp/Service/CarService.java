package com.PBachta.KomisApp.Service;

import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();

        for(Car car : carRepository.findAll()){
            carList.add(car);
        }

        if (carList.size() == 0) {
            throw new RuntimeException("There are no cars in database");
        }
        return carList;
    }


    public Car getById(long id) {
        Car car = carRepository.findOne(id);
        if (car == null) {
            throw new RuntimeException("Car with id "+id+" not found");
        }
        return car;
    }


    public Car post(String maker, String model, String registrationNumber, String vinNumber) {
        Car car = new Car(maker, model, registrationNumber, vinNumber);
        carRepository.save(car);
        return car;
    }


    public List<Car> delete(long id) {
        carRepository.delete(id);
        return getAll();
    }


    public Car put(long id, String maker, String model, String registrationNumber, String vinNumber) {
        Car car = carRepository.findOne(id);
        if (car == null) {
            throw new RuntimeException("Car with id "+id+" not found");
        }

        if(maker == null)
            maker = car.getMaker();
        if(model == null)
            model = car.getModel();
        if (registrationNumber == null)
            registrationNumber = car.getRegistrationNumber();
        if (vinNumber == null)
            vinNumber = car.getVinNumber();

        Car updatedCar = new Car(id, maker, model, registrationNumber, vinNumber);
        carRepository.save(updatedCar);
        return carRepository.findOne(id);
    }

//______________________________________________ additional functions___________________________________________________


    public List<Car> getByMaker(String maker) {
        List<Car> carList = new ArrayList<>();
        for(Car car : carRepository.findByMaker(maker)){
            carList.add(car);
        }

        if (carList.size() == 0) {
            throw new RuntimeException("Car with maker "+maker+" not found");
        }
        return carList;
    }


    public List<Car> getByModel(String model) {
        List<Car> carList = new ArrayList<>();
        for(Car car : carRepository.findByModel(model)){
            carList.add(car);
        }

        if (carList.size() == 0) {
            throw new RuntimeException("Car with model "+model+" not found");
        }
        return carList;
    }


    public Car getByVinNumber(String vinNumber) {
        Car car = carRepository.findByVinNumber(vinNumber);
        if (car == null) {
            throw new RuntimeException("Car with VIN number "+vinNumber+" not found");
        }
        return car;
    }


    public Car getByRegistrationNumber(String registrationNumber) {
        Car car = carRepository.findByRegistrationNumber(registrationNumber);
        if (car == null) {
            throw new RuntimeException("Car with registration number "+registrationNumber+" not found");
        }
        return car;
    }
}
