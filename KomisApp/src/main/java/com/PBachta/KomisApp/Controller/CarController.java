package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Service.CarServiceInteface;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
@Api(description = "Rest API for car operations", tags = "Car API")
public class CarController {

    @Autowired
    private CarServiceInteface carService;


    //Show all cars in database
    @GetMapping(value = "", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display all cars in database", response = Car.class)
    @ResponseBody
    public List<Car> getAllCars() {

        return carService.getAll();
    }


    //Search car by id
    @GetMapping(value = "/{ID Number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display car with specified id", response = Car.class)
    @ResponseBody
    public Car getCarById(@ApiParam(value = "ID of car to display", required =true)@PathVariable("ID Number") Long id) {

        return carService.getById(id);
    }


    //Add new car to database
    @PostMapping(value = "", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Add new car to database", response = Car.class)
    @ResponseBody
    public Car postNewCar(@ApiParam(value = "Manufacturer of the car being added",required =true)@RequestParam("Manufacturer") Maker maker,
                          @ApiParam(value = "Engine capacity of the car being added",required =true)@RequestParam("Engine Capacity") Integer engineCapacity,
                          @ApiParam("Number of seats in the car being added")@RequestParam(value = "Number Of Seats",required =false) Integer numberOfSeats,
                          @ApiParam(value = "First registration date of the car being added",required =true)@RequestParam("First Registration Date") Date firstRegistrationDate,
                          @ApiParam(value = "Registration card issue date for the car being added",required =true)@RequestParam("Registration Card Issue Date") Date registrationCardIssueDate,
                          @ApiParam(value = "Registration number of the car being added",required =true)@RequestParam("Registration Number") String registrationNumber) {

        return carService.post(maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
    }


    //Delete car from database
    @DeleteMapping(value = "/{ID Number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Delete car with specified id from database", response = Car.class)
    @ResponseBody
    public List<Car> deleteCar(@ApiParam(value = "ID of the car to delete" ,required =true)@PathVariable("ID Number") Long id) {

        return carService.delete(id);
    }


    //Update existing car information
    @PutMapping(value = "/{ID Number}", produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Edit information of specified car", response = Car.class)
    @ResponseBody
    public Car putNewCarData(@ApiParam(value = "ID of the car to edit",required =true)@PathVariable("ID Number") Long id,
                             @ApiParam("New car manufacturer for edited car")@RequestParam(value = "Manufacturer",required =false) Maker maker,
                             @ApiParam("New engine capacity for edited car")@RequestParam(value = "Engine Capacity",required =false) Integer engineCapacity,
                             @ApiParam("New number of seats for edited car")@RequestParam(value = "Number Of Seats",required =false) Integer numberOfSeats,
                             @ApiParam("New first registration date for edited car")@RequestParam(value = "First Registration Date",required =false) Date firstRegistrationDate,
                             @ApiParam("New registration card issue date for edited car")@RequestParam(value = "Registration Card Issue Date",required =false) Date registrationCardIssueDate,
                             @ApiParam("New registration number for edited car")@RequestParam(value = "Registration Number",required =false) String registrationNumber) {

        return carService.put(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
    }
}