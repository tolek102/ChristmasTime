package com.PBachta.KomisApp.Controller;

import com.PBachta.KomisApp.DataTypes.Maker;
import com.PBachta.KomisApp.Entity.Car;
import com.PBachta.KomisApp.Service.CarServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController{

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
                          @RequestParam("numberOfSeats") Integer numberOfSeats,
                          @RequestParam("firstRegistrationDate") String firstRegistrationDate,
                          @RequestParam("registrationCardIssueDate") String registrationCardIssueDate,
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
                             @RequestParam(value = "firstRegistrationDate", required = false) String firstRegistrationDate,
                             @RequestParam(value = "registrationCardIssueDate", required = false) String registrationCardIssueDate,
                             @RequestParam(value = "registrationNumber", required = false) String registrationNumber) {

        return carService.put(id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber);
    }

//______________________________________________ additional functions___________________________________________________

//    //Search car by maker
//    @GetMapping(value = "/maker={maker}")
//    @ResponseBody
//    public List<Car> getCarByMaker(@PathVariable("maker") String maker) {
//
//        return carService.getByMaker(maker);
//    }
//
//
//    //Search car by model
//    @GetMapping(value = "/model={model}")
//    @ResponseBody
//    public List<Car> getCarByModel(@PathVariable("model") String model) {
//
//        return carService.getByModel(model);
//    }
//
//
//    //Search car by VIN number
//    @GetMapping(value = "/vin={vinNumber}")
//    @ResponseBody
//    public Car getCarByVinNumber(@PathVariable("vinNumber") String vinNumber) {
//
//        return carService.getByVinNumber(vinNumber);
//    }
//
//
//    //Search car by registration number
//    @GetMapping(value = "/registrationNr={registrationNumber}")
//    @ResponseBody
//    public Car getCarByRegistrationNumber(@PathVariable("registrationNumber") String registrationNumber) {
//
//        return carService.getByRegistrationNumber(registrationNumber);
//    }
}