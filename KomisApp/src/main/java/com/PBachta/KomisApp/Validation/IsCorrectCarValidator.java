package com.PBachta.KomisApp.Validation;



import com.PBachta.KomisApp.Entity.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsCorrectCarValidator implements ConstraintValidator<IsCorrectCar, Car> {
    @Override
    public void initialize(IsCorrectCar constraintAnnotation) {

    }

    @Override
    public boolean isValid(Car value, ConstraintValidatorContext context) {
// if (value == null) return true;

        String rn = value.getRegistrationNumber();

        if (value.getRegistrationNumber() == null) {
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("Maker is required")
             .addPropertyNode("Maker").addConstraintViolation();
            return false;
        }

        if(!rn.matches("[A-Z][A-Z][\\d]*") || rn.length() > 10){

            System.out.println("DUUUUUUUUUUUUUUUUUUUPA " + value.getRegistrationNumber().toString().substring(0,1));
            System.out.println("DUUUUUUUUUUUUUUUUUUUPA " + value.getRegistrationNumber().substring(1,2));
            return false;
        }

        if(value.getRegistrationNumber().toString().substring(0,1).equals(value.getRegistrationNumber().toString().substring(1,2))){
            return false;
        }

        if((value.getRegistrationNumber().substring(0)).equals(value.getRegistrationNumber().substring(1))) {
            System.out.println(value.getRegistrationNumber().substring(0));
            return false;
        }

// if (value.isCompany()){
//        if (value.getTaxId() == null || value.getTaxId().isEmpty()) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("TaxId is required for company address")
//                    .addPropertyNode("taxId").addConstraintViolation();
//            return false;
//        }
//}
        return true;
    }
}