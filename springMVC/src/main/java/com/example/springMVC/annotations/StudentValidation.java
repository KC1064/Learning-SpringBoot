package com.example.springMVC.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = StudentValidator.class)
public @interface StudentValidation {
    String message() default "Not Valid number of Students";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
