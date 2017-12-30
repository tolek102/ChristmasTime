package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController{
    @Autowired
    private CarRepository carRepository;

    //Show all cars in database
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
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


    //Search car by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Car getById(@PathVariable("id") long id) {
        Car car = carRepository.findOne(id);
        if (car == null) {
            throw new RuntimeException("Car with id "+id+" not found");
        }
        return car;
    }


    //Add new car to database
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Car postNewCar(@RequestParam("maker") String maker,
                                     @RequestParam("model") String model,
                                     @RequestParam("registrationNumber") String registrationNumber,
                                     @RequestParam("vinNumber") String vinNumber) {
        Car car = new Car(maker, model, registrationNumber, vinNumber);
        carRepository.save(car);
        return car;
    }


    //Delete car from database
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public List<Car> deleteCar(@PathVariable("id") long id) {
        carRepository.delete(id);
        return getAll();
    }


    //Update existing car information
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Car putNewCarData(@PathVariable("id") long id,
                                        @RequestParam(value = "maker", required = false) String maker,
                                        @RequestParam(value = "model", required = false) String model,
                                        @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
                                        @RequestParam(value = "vinNumber", required = false) String vinNumber) {
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

    //Search car by maker
    @RequestMapping(value = "/maker={maker}", method = RequestMethod.GET)
    @ResponseBody
    public List<Car> getByMaker(@PathVariable("maker") String maker) {
        List<Car> carList = new ArrayList<>();
        for(Car car : carRepository.findByMaker(maker)){
            carList.add(car);
        }

        if (carList.size() == 0) {
            throw new RuntimeException("Car with maker "+maker+" not found");
        }
        return carList;
    }


    //Search car by model
    @RequestMapping(value = "/model={model}", method = RequestMethod.GET)
    @ResponseBody
    public List<Car> getByModel(@PathVariable("model") String model) {
        List<Car> carList = new ArrayList<>();
        for(Car car : carRepository.findByModel(model)){
            carList.add(car);
        }

        if (carList.size() == 0) {
            throw new RuntimeException("Car with model "+model+" not found");
        }
        return carList;
    }


    //Search car by VIN number
    @RequestMapping(value = "/vin={vinNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Car getByVinNumber(@PathVariable("vinNumber") String vinNumber) {
        Car car = carRepository.findByVinNumber(vinNumber);
        if (car == null) {
            throw new RuntimeException("Car with VIN number "+vinNumber+" not found");
        }
        return car;
    }


    //Search car by registration number
    @RequestMapping(value = "/registrationNr={registrationNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Car getByRegistrationNumber(@PathVariable("registrationNumber") String registrationNumber) {
        Car car = carRepository.findByRegistrationNumber(registrationNumber);
        if (car == null) {
            throw new RuntimeException("Car with registration number "+registrationNumber+" not found");
        }
        return car;
    }
}