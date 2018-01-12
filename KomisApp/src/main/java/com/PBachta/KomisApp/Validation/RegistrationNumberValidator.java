//package com.PBachta.KomisApp.Validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class RegistrationNumberValidator implements ConstraintValidator<RegistrationNumber, String> {
//    @Override
//    public void initialize(RegistrationNumber registrationNumber) {
//
//    }
//
//    @Override
//    public boolean isValid(String registrationNumberField, ConstraintValidatorContext context) {
//        if (registrationNumberField == null) {
////            addMessage("Registration number is required", "Registration number", context);
//            return false;
//        }
//        if (!registrationNumberField.matches("[A-Z][A-Z][\\d]*")
//                || registrationNumberField.length() > 10
//                || registrationNumberField.substring(0, 1).equals(registrationNumberField.substring(1, 2))) {
//            addMessage("Registration number is incorrect", "Registration number", context);
//            return false;
//        }
//
//        return true;
//    }
//
//    private void addMessage(String message, String name, ConstraintValidatorContext context) {
//        context.disableDefaultConstraintViolation();
//        context.buildConstraintViolationWithTemplate(message)
//                .addPropertyNode(name).addConstraintViolation();
//    }
//}
