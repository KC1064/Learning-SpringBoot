package com.example.springMVC.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data // Automatically generates getters, setters, toString(), equals(), and hashCode() to remove boilerplate code.
@Builder // Allows creating objects in a clean, readable, and safe way using the Builder pattern.
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
