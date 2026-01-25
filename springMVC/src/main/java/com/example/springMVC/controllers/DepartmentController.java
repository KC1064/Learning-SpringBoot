package com.example.springMVC.controllers;


import com.example.springMVC.dto.DepartmentDTO;
import com.example.springMVC.entities.DepartmentEntity;
import com.example.springMVC.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    1. Get Department By id
    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDTO> getDeptById(@PathVariable Long id){
        DepartmentDTO department = departmentService.getDeptById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
//    2. Get All Departments
    @GetMapping(path = "/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departments = departmentService.getAllDept();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }
//    3. Create new departments
    @PostMapping(path = "/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO newDept){
        DepartmentDTO department = departmentService.createDept(newDept);
//        System.out.println(department.getEmail() + " " + department.getStudents());
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
//    4. Update Departments
//    5. Patch Departments information
//    6. Delete department by id
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteDeptById(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.deleteById(id),HttpStatus.OK);
    }
}
