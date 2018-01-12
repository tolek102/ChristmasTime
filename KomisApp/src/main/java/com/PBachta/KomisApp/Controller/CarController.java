package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Service.CarServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    @Autowired
    private CarServiceInteface carService;


    //Show all cars in database
    @GetMapping(value = "")
    @ResponseBody
    public List<Car> getAllCars() {

        return carService.getAll();
    }


    //Search car by id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Car getCarById(@PathVariable("id") Long id) {

        return carService.getById(id);
    }


    //Add new car to database
    @PostMapping(value = "")
    @ResponseBody
    public Car postNewCar(@RequestParam("maker") Maker maker,
                                     @RequestParam("engineCapacity") Integer engineCapacity,
                                     @RequestParam(value = "numberOfSeats", required = false) Integer numberOfSeats,
                                     @RequestParam("firstRegistrationDate") Date firstRegistrationDate,
                                     @RequestParam("registrationCardIssueDate") Date registrationCardIssueDate,
                                     @RequestParam("registrationNumber") String registrationNumber) {


        return carService.post(maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
    }


    //Delete car from database
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public List<Car> deleteCar(@PathVariable("id") Long id) {

        return carService.delete(id);
    }


    //Update existing car information
    @PutMapping(value = "/{id}")
    @ResponseBody
    public Car putNewCarData(@PathVariable(value = "id") Long id,
                                        @RequestParam(value = "maker", required = false) Maker maker,
                                        @RequestParam(value = "engineCapacity", required = false) Integer engineCapacity,
                                        @RequestParam(value = "numberOfSeats", required = false) Integer numberOfSeats,
                                        @RequestParam(value = "firstRegistrationDate", required = false) Date firstRegistrationDate,
                                        @RequestParam(value = "registrationCardIssueDate", required = false) Date registrationCardIssueDate,
                                        @RequestParam(value = "registrationNumber", required = false) String registrationNumber) {

        return carService.put(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
    }
}