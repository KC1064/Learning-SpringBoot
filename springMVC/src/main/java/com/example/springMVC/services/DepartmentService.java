package com.example.springMVC.services;

import com.example.springMVC.dto.DepartmentDTO;
import com.example.springMVC.entities.DepartmentEntity;
import com.example.springMVC.exceptions.ResourceNotFoundException;
import com.example.springMVC.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
//    Departments Exists or not
    public void deptExists(Long id){
        boolean exists = departmentRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Department with id: "+ id + " not found.");
    }

// Get Department by id
    public DepartmentDTO getDeptById(Long id) {
       return modelMapper.map(departmentRepository.findById(id), DepartmentDTO.class);
    }

//    Create new Department
    public DepartmentDTO createDept(DepartmentDTO newDept) {
        DepartmentEntity deptEntity = modelMapper.map(newDept,DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(deptEntity), DepartmentDTO.class);
    }

    // Get All Departments
    public List<DepartmentDTO> getAllDept() {
        List<DepartmentEntity> departmentEntity = departmentRepository.findAll();
        return departmentEntity
                .stream()
                .map(deptEntity -> modelMapper.map(deptEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

// Delete Department by id
    public String deleteById(Long id) {
        deptExists(id);
        departmentRepository.deleteById(id);
        return "Department Deleted Successfully";
    }
}
