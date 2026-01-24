package com.example.springMVC.services;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.entities.EmployeeEntity;
import com.example.springMVC.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(emp, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO create(EmployeeDTO newEmp) {
        EmployeeEntity newEmployeeEntity = modelMapper.map(newEmp,EmployeeEntity.class);
        EmployeeEntity saveEmp = employeeRepository.save(newEmployeeEntity);
        return modelMapper.map(saveEmp,EmployeeDTO.class);
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Successfully Deleted emp with id: "+ id;
    }
}
