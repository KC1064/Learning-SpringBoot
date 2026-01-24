package com.example.springMVC.controllers;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path="/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO newEmp){
        return employeeService.create(newEmp);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
