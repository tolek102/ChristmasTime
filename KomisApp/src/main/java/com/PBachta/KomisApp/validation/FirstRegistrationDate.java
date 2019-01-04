package com.PBachta.KomisApp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FirstRegistrationDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstRegistrationDate {

  String message() default "{FirstRegistrationDate is incorrect}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
