package com.example.springMVC.dto;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {
    private Long id;
    private String fullName;
    private Integer age;
    private String email;
    private Boolean active;
    private String dateOfJoining;

    public EmployeeDTO(Long id, String fullName, Integer age, String email, Boolean active, String dateOfJoining) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.active = active;
        this.dateOfJoining = dateOfJoining;
    }

    public EmployeeDTO(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
