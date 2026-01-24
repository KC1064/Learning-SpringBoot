package com.example.springMVC.controllers;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO newEmp){
        return employeeService.create(newEmp);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long empId,
                                                      @RequestBody EmployeeDTO employee){
        return employeeService.updateEmployee(empId,employee);
    }

    @PatchMapping(path = "/{empId}")
    public ResponseEntity<EmployeeDTO> editEmployee(@PathVariable Long empId,
                             @RequestBody Map<String, Objects> body){
        return employeeService.editEmployee(empId,body);
    }
}
