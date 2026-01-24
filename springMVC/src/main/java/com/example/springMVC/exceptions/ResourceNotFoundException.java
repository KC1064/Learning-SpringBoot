package com.example.springMVC.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){ super(message);}
}
