package com.PBachta.KomisApp.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;
import java.util.Calendar;

public class FirstRegistrationDateValidator implements ConstraintValidator<FirstRegistrationDate, Date> {

    @Override
    public void initialize(FirstRegistrationDate firstRegistrationDate) {
    }

    @Override
    public boolean isValid(Date firstRegistrationDateField, ConstraintValidatorContext context) {
        Calendar currentTime = Calendar.getInstance();
        Date today = new Date((currentTime.getTime()).getTime());

        if (firstRegistrationDateField.before(new Date(0, 01, 01)) || firstRegistrationDateField.after(today)) {
            addMessage("First Registration Date is incorrect, acceptable values from 1900-01-01 till today", context);
            return false;
        }
        return true;
    }


    private void addMessage(String message, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}