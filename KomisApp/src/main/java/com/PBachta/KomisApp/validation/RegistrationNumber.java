package com.PBachta.KomisApp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegistrationNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistrationNumber {

  String message() default "{Registration Number is incorrect}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
