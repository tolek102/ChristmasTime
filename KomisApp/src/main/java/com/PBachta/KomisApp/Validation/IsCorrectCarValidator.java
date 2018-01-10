package com.PBachta.KomisApp.Validation;


import com.PBachta.KomisApp.Entity.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;
import java.util.Calendar;

public class IsCorrectCarValidator implements ConstraintValidator<IsCorrectCar, Car> {

    @Override
    public void initialize(IsCorrectCar constraintAnnotation) {
    }


    @Override
    public boolean isValid(Car car, ConstraintValidatorContext context) {
// if (value == null) return true;


        String registrationNumber = car.getRegistrationNumber();
        if (registrationNumber == null) {
            addMessage("Registration number is required","Registration number", context);
            return false;
        }

        if(!registrationNumber.matches("[A-Z][A-Z][\\d]*") || registrationNumber.length() > 10 || registrationNumber.substring(0,1).equals(registrationNumber.substring(1,2))){
            addMessage("Registration number is incorrect","Registration number", context);
            return false;
        }

        Integer engineCapacity = car.getEngineCapacity();
        Integer minEngineCapacity = 50;
        Integer maxEngineCapacity = 6999;
        if(engineCapacity < minEngineCapacity || engineCapacity > maxEngineCapacity){
            addMessage("EngineCapacityn number is incorrect","Engine Capacity", context);
            return false;
        }

        Integer numberOfSeats = car.getNumberOfSeats();
        Integer minNumberOfSeats = 1;
        Integer maxNumberOfSeats = 6;
        if(numberOfSeats < minNumberOfSeats || numberOfSeats > maxNumberOfSeats){
            addMessage("NumberOfSeats number is incorrect","Number of seats", context);
            return false;
        }

        Calendar currenttime = Calendar.getInstance();
        Date today = new Date((currenttime.getTime()).getTime());

        Date firstRegistration = car.getFirstRegistrationDate();
        if(firstRegistration.before(new Date(0,01,01)) || firstRegistration.after(today)) {
            addMessage("FirstRegistration Date incorrect", "First Registration Date", context);
            return false;
        }

        Date cardIssueDate = car.getRegistrationCardIssueDate();
        if(cardIssueDate.before(firstRegistration) || cardIssueDate.after(today)) {
            addMessage("RegistrationCardIssue Date is incorrect", "Registration Card Issue Date", context);
            return false;
        }

        return true;
    }

    private void addMessage(String message, String name, ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(name).addConstraintViolation();
    }
}