package com.PBachta.KomisApp.validation;

import com.PBachta.KomisApp.data.Maker;
import com.PBachta.KomisApp.entity.Car;
import org.junit.Before;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Date;
import java.util.Set;
import static org.junit.Assert.assertFalse;

public class CarValidationTest {

    private static Validator validator;

    Car car = new Car(Maker.HONDA, 1589, 5, new Date(98, 1, 5), new Date(98, 2, 5), "AB1111");

    @Before
    public void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void engineCapacityIsValidTest() {
        car.setEngineCapacity(10);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertFalse("engineCapacityIsValidTest failed", violations.isEmpty());

        car.setEngineCapacity(7000);
        Set<ConstraintViolation<Car>> violations1 = validator.validate(car);
        assertFalse("engineCapacityIsValidTest failed", violations1.isEmpty());
    }

    @Test
    public void numberOfSeatsIsValidTest() {
        car.setNumberOfSeats(0);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertFalse("numberOfSeatsIsValidTest failed", violations.isEmpty());

        car.setNumberOfSeats(7);
        Set<ConstraintViolation<Car>> violations1 = validator.validate(car);
        assertFalse("numberOfSeatsIsValidTest failed", violations1.isEmpty());
    }

    @Test
    public void firstRegistrationDateIsValidTest() {
        car.setFirstRegistrationDate(new Date(-1, 1, 5));
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertFalse("firstRegistrationDateIsValidTest failed", violations.isEmpty());

        car.setFirstRegistrationDate(new Date(200, 1, 5));
        Set<ConstraintViolation<Car>> violations1 = validator.validate(car);
        assertFalse("firstRegistrationDateIsValidTest failed", violations1.isEmpty());
        System.out.println(car.getEngineCapacity());
    }

    @Test
    public void registrationCardIssueDateIsValidTest() {
        car.setRegistrationCardIssueDate(new Date(98, 1, 1));
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertFalse("registrationCardIssueDateIsValidTest failed", violations.isEmpty());


        car.setRegistrationCardIssueDate(new Date(200, 1, 5));
        Set<ConstraintViolation<Car>> violations1 = validator.validate(car);
        assertFalse("registrationCardIssueDateIsValidTest failed", violations1.isEmpty());
    }

    @Test
    public void registrationNumberIsValidTest() {
        car.setRegistrationNumber("AA112");
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertFalse("registrationNumberIsValidTest failed", violations.isEmpty());

        car.setRegistrationNumber("ABC");
        Set<ConstraintViolation<Car>> violations1 = validator.validate(car);
        assertFalse("registrationNumberIsValidTest failed", violations1.isEmpty());

        car.setRegistrationNumber("AB123456789");
        Set<ConstraintViolation<Car>> violations2 = validator.validate(car);
        assertFalse("registrationNumberIsValidTest failed", violations2.isEmpty());
    }
}
