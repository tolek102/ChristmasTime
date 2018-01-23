package com.PBachta.KomisApp.validation;

import com.PBachta.KomisApp.entity.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;

public class CustomerValiationTest {

    private static Validator validator;

    Customer customer = new Customer("Jan", "Kowalski", "NHW399139", "43062460106");

    @Before
    public void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void firstNameIsValidTest() {
        customer.setFirstName("a");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse("firstNameIsValidTest failed", violations.isEmpty());

        customer.setFirstName("qwertyuioplkjhgfdsazxcvbnmqwert");
        Set<ConstraintViolation<Customer>> violations1 = validator.validate(customer);
        assertFalse("firstNameIsValidTest failed", violations1.isEmpty());
    }

    @Test
    public void lastNameIsValidTest() {
        customer.setLastName("a");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse("lastNameIsValidTest failed", violations.isEmpty());

        customer.setLastName("qwertyuioplkjhgfdsazxcvbnmqwert");
        Set<ConstraintViolation<Customer>> violations1 = validator.validate(customer);
        assertFalse("lastNameIsValidTest failed", violations1.isEmpty());
    }

    @Test
    public void idCardNumberValidTest() {
        customer.setIdCardNumber("A");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse("idCardNumberValidTest failed", violations.isEmpty());

        customer.setIdCardNumber("AB");
        Set<ConstraintViolation<Customer>> violations1 = validator.validate(customer);
        assertFalse("idCardNumberValidTest failed", violations1.isEmpty());

        customer.setIdCardNumber("ABC");
        Set<ConstraintViolation<Customer>> violations2 = validator.validate(customer);
        assertFalse("idCardNumberValidTest failed", violations2.isEmpty());

        customer.setIdCardNumber("ABC1234567");
        Set<ConstraintViolation<Customer>> violations3 = validator.validate(customer);
        assertFalse("idCardNumberValidTest failed", violations3.isEmpty());

        customer.setIdCardNumber("123456789");
        Set<ConstraintViolation<Customer>> violations4 = validator.validate(customer);
        assertFalse("idCardNumberValidTest failed", violations4.isEmpty());
    }

    @Test
    public void peselNumberIsValidTest() {
        customer.setPeselNumber("a0123456789");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse("peselNumberIsValidTest failed", violations.isEmpty());

        customer.setPeselNumber("0123456789");
        Set<ConstraintViolation<Customer>> violations1 = validator.validate(customer);
        assertFalse("peselNumberIsValidTest failed", violations1.isEmpty());

        customer.setPeselNumber("012345678901");
        Set<ConstraintViolation<Customer>> violations2 = validator.validate(customer);
        assertFalse("peselNumberIsValidTest failed", violations2.isEmpty());

        customer.setPeselNumber("012345 67890");
        Set<ConstraintViolation<Customer>> violations3 = validator.validate(customer);
        assertFalse("peselNumberIsValidTest failed", violations3.isEmpty());
    }


}
