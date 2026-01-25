package com.example.springMVC.advices;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ApiResponse<T> {
    private LocalTime timeStamp;
    private ApiError error;
    private T data;


    public ApiResponse() {
        this.timeStamp = LocalTime.from(LocalDateTime.now());
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error){
        this();
        this.error = error;
    }
}
