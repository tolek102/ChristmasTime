package com.PBachta.KomisApp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RegistrationCardIssueDateValidator.class)
public @interface RegistrationCardIssueDate {

  String message() default "RegistrationCardIssueDate is incorrect";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
