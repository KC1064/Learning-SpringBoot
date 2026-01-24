package com.example.springMVC.services;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.entities.EmployeeEntity;
import com.example.springMVC.exceptions.ResourceNotFoundException;
import com.example.springMVC.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public void userExists(Long id){
        boolean exists = employeeRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Employee with id "+ id + " not found");
    }

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
//    Get Employee By Id
    public EmployeeDTO getEmployeeById(Long id) {
        userExists(id);
        return (modelMapper.map(employeeRepository.findById(id), EmployeeDTO.class));
    }

//    Get All Employees List
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return (employees.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList()));
    }

//    Create new Employee record
    public EmployeeDTO create(EmployeeDTO newEmp) {
        EmployeeEntity newEmployeeEntity = modelMapper.map(newEmp,EmployeeEntity.class);
        EmployeeEntity saveEmp = employeeRepository.save(newEmployeeEntity);
        return modelMapper.map(saveEmp,EmployeeDTO.class);
    }

//    Delete employee record by id
    public String deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).orElse(null);
        if(emp == null) throw new ResourceNotFoundException("Employee with id "+ id + " not found");
        employeeRepository.deleteById(id);
        return ("Successfully Deleted emp with id: "+ id);
    }

// Update Employee record
    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO employee) {

        EmployeeEntity existingEmp = employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + empId + " not found"));

        existingEmp.setFullName(employee.getFullName());
        existingEmp.setAge(employee.getAge());
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setActive(employee.getActive());
        existingEmp.setDateOfJoining(employee.getDateOfJoining());

        EmployeeEntity updatedEmp = employeeRepository.save(existingEmp);
        return modelMapper.map(updatedEmp, EmployeeDTO.class);
    }

// Edit Employee Records
    public EmployeeDTO editEmployee(Long empId, Map<String, Object> body) {
        EmployeeEntity existingEmp = employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + empId + " not found"));

        body.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, existingEmp, value);
        });

        return (modelMapper.map(employeeRepository.save(existingEmp),EmployeeDTO.class));

    }
}
