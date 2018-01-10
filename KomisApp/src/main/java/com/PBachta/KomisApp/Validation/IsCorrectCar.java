package com.PBachta.KomisApp.Validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsCorrectCarValidator.class })
public @interface IsCorrectCar {
    String message() default "Car data are incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
