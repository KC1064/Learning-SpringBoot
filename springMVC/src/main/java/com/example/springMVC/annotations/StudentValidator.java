package com.example.springMVC.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentValidator implements ConstraintValidator<StudentValidation,Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        boolean isPrime = (number > 1 && java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(i -> number % i != 0));
        return !isPrime;
    }
}
