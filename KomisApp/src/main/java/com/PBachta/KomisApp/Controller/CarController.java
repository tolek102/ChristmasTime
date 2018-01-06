package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController{

    @Autowired
    private CarService carService;

    //Show all cars in database
    @GetMapping(value = "")
    @ResponseBody
    public List<Car> getAllCars() {

        return carService.getAll();
    }


    //Search car by id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Car getCarById(@PathVariable("id") long id) {

        return carService.getById(id);
    }


    //Add new car to database
    @PostMapping(value = "")
    @ResponseBody
    public Car postNewCar(@RequestParam("maker") String maker,
                          @RequestParam("model") String model,
                          @RequestParam("registrationNumber") String registrationNumber,
                          @RequestParam("vinNumber") String vinNumber) {

        return carService.post(maker, model, registrationNumber, vinNumber);
    }


    //Delete car from database
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public List<Car> deleteCar(@PathVariable("id") long id) {

        return carService.delete(id);
    }


    //Update existing car information
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Car putNewCarData(@PathVariable("id") long id,
                             @RequestParam(value = "maker", required = false) String maker,
                             @RequestParam(value = "model", required = false) String model,
                             @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
                             @RequestParam(value = "vinNumber", required = false) String vinNumber) {

        return carService.put(id, maker, model, registrationNumber, vinNumber);
    }

//______________________________________________ additional functions___________________________________________________

    //Search car by maker
    @GetMapping(value = "/maker={maker}")
    @ResponseBody
    public List<Car> getCarByMaker(@PathVariable("maker") String maker) {

        return carService.getByMaker(maker);
    }


    //Search car by model
    @GetMapping(value = "/model={model}")
    @ResponseBody
    public List<Car> getCarByModel(@PathVariable("model") String model) {

        return carService.getByModel(model);
    }


    //Search car by VIN number
    @GetMapping(value = "/vin={vinNumber}")
    @ResponseBody
    public Car getCarByVinNumber(@PathVariable("vinNumber") String vinNumber) {

        return carService.getByVinNumber(vinNumber);
    }


    //Search car by registration number
    @GetMapping(value = "/registrationNr={registrationNumber}")
    @ResponseBody
    public Car getCarByRegistrationNumber(@PathVariable("registrationNumber") String registrationNumber) {

        return carService.getByRegistrationNumber(registrationNumber);
    }
}