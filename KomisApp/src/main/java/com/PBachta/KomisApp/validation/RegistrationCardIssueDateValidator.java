package com.PBachta.KomisApp.validation;

import com.PBachta.KomisApp.entity.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;
import java.util.Calendar;

public class RegistrationCardIssueDateValidator implements ConstraintValidator<RegistrationCardIssueDate, Car> {

  @Override
  public void initialize(RegistrationCardIssueDate constraintAnnotation) {
  }

  @Override
  public boolean isValid(Car car, ConstraintValidatorContext context) {
    Calendar currentTime = Calendar.getInstance();
    Date today = new Date((currentTime.getTime()).getTime());

    Date firstRegistration = car.getFirstRegistrationDate();
    Date cardIssueDate = car.getRegistrationCardIssueDate();

    if (cardIssueDate.before(firstRegistration) || cardIssueDate.after(today)) {
      addMessage("RegistrationCardIssue Date is incorrect, acceptable values from first registration date till today", context);
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
