package com.example.springMVC.controllers;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.exceptions.ResourceNotFoundException;
import com.example.springMVC.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        if(allEmployees.size() == 0) throw new ResourceNotFoundException("No Employees Details found");
        return ResponseEntity.ok(allEmployees);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO newEmp){
        EmployeeDTO newEmployee = employeeService.create(newEmp);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

    @PutMapping(path = "/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long empId,
                                                      @RequestBody @Valid EmployeeDTO employee){
        return new ResponseEntity<>(employeeService.updateEmployee(empId,employee),HttpStatus.OK);
    }

    @PatchMapping(path = "/{empId}")
    public ResponseEntity<EmployeeDTO> editEmployee(@PathVariable Long empId,
                             @RequestBody Map<String, Object> body){
        return new ResponseEntity<>(employeeService.editEmployee(empId,body),HttpStatus.ACCEPTED);
    }
}
