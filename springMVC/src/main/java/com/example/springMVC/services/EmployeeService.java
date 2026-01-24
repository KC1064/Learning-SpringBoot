package com.example.springMVC.services;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.entities.EmployeeEntity;
import com.example.springMVC.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public ResponseEntity<EmployeeDTO> getEmployeeById(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).orElse(null);
        if(emp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(modelMapper.map(emp, EmployeeDTO.class));
    }

    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList()));
    }

    public ResponseEntity<EmployeeDTO> create(EmployeeDTO newEmp) {
        EmployeeEntity newEmployeeEntity = modelMapper.map(newEmp,EmployeeEntity.class);
        EmployeeEntity saveEmp = employeeRepository.save(newEmployeeEntity);
        if(saveEmp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(modelMapper.map(saveEmp,EmployeeDTO.class));
    }

    public ResponseEntity<String> deleteEmployee(Long id) {
        EmployeeEntity doesExist = employeeRepository.findById(id).orElse(null);
        if(doesExist == null) return ResponseEntity.notFound().build();
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted emp with id: "+ id);
    }

    public ResponseEntity<EmployeeDTO> updateEmployee(Long empId, EmployeeDTO employee) {
        EmployeeEntity updateEmpEntity = modelMapper.map(employee,EmployeeEntity.class);
        EmployeeEntity exists = employeeRepository.findById(empId).orElse(null);
        if(exists == null) return ResponseEntity.notFound().build();
        EmployeeEntity updateEmp = employeeRepository.save(updateEmpEntity);
        return ResponseEntity.ok(modelMapper.map(updateEmp,EmployeeDTO.class));

    }

    public ResponseEntity<EmployeeDTO> editEmployee(Long empId, Map<String, Objects> body) {
        EmployeeEntity exists = employeeRepository.findById(empId).orElse(null);
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();

        if(exists == null) return ResponseEntity.notFound().build();
        body.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });

        return ResponseEntity.ok(modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class));

    }
}
