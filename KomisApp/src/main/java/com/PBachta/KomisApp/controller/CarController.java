package com.PBachta.KomisApp.controller;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;
import com.PBachta.KomisApp.service.CarServiceInteface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = {"application/json", "application/xml"})
@Api(description = "Rest API for car operations", tags = "Car API")
public class CarController {

  @Autowired
  private CarServiceInteface carService;


  //Show all cars in database
  @GetMapping(value = "")
  @ApiOperation(value = "Display all cars in database", response = Car.class)
  @ResponseBody
  public List<Car> getAllCars() {

    return carService.getAll();
  }


  //Search car by id
  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Display car with specified id", response = Car.class)
  @ResponseBody
  public Car getCarById(@ApiParam(value = "ID of car to display", required = true)
                        @PathVariable("id") Long id) {

    return carService.getById(id);
  }


  //Add new car to database
  @PostMapping(value = "")
  @ApiOperation(value = "Add new car to database", response = Car.class)
  @ResponseBody
  public Car postNewCar(@ApiParam(value = "Manufacturer of the car being added", required = true)
                          @RequestParam("maker") Maker maker,
                        @ApiParam(value = "Engine capacity of the car being added [50-6999]", required = true)
                          @RequestParam("engineCapacity") Integer engineCapacity,
                        @ApiParam("Number of seats in the car being added [1-6]")
                          @RequestParam(value = "numberOfSeats", required = false) Integer numberOfSeats,
                        @ApiParam(value = "First registration date of the car being added [yyyy-mm-dd]", required = true)
                          @RequestParam("firstRegistrationDate") Date firstRegistrationDate,
                        @ApiParam(value = "Registration card issue date for the car being added [yyyy-mm-dd]", required = true)
                          @RequestParam("registrationCardIssueDate") Date registrationCardIssueDate,
                        @ApiParam(value = "Registration number of the car being added", required = true)
                          @RequestParam("registrationNumber") String registrationNumber) {

    return carService.post(maker, engineCapacity, numberOfSeats,
        firstRegistrationDate, registrationCardIssueDate, registrationNumber);
  }


  //Delete car from database
  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Delete car with specified id from database", response = Car.class)
  @ResponseBody
  public List<Car> deleteCar(@ApiParam(value = "ID of the car to delete", required = true)
                              @PathVariable("id") Long id) {

    return carService.delete(id);
  }


  //Update existing car information
  @PutMapping(value = "/{id}")
  @ApiOperation(value = "Edit information of specified car", response = Car.class)
  @ResponseBody
  public Car putNewCarData(@ApiParam(value = "ID of the car to edit", required = true)
                             @PathVariable("id") Long id,
                           @ApiParam("New car manufacturer for edited car")
                             @RequestParam(value = "maker", required = false) Maker maker,
                           @ApiParam("New engine capacity for edited car [50-6999]")
                             @RequestParam(value = "engineCapacity", required = false) Integer engineCapacity,
                           @ApiParam("New number of seats for edited car [1-6]")
                             @RequestParam(value = "numberOfSeats", required = false) Integer numberOfSeats,
                           @ApiParam("New first registration date for edited car [yyyy-mm-dd]")
                             @RequestParam(value = "firstRegistrationDate", required = false) Date firstRegistrationDate,
                           @ApiParam("New registration card issue date for edited car [yyyy-mm-dd]")
                             @RequestParam(value = "registrationCardIssueDate", required = false) Date registrationCardIssueDate,
                           @ApiParam("New registration number for edited car")
                             @RequestParam(value = "registrationNumber", required = false) String registrationNumber) {

    return carService.put(id, maker, engineCapacity, numberOfSeats,
        firstRegistrationDate, registrationCardIssueDate, registrationNumber);
  }
}
