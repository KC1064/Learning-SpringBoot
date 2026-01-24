package com.example.springMVC.configs;

import com.example.springMVC.dto.EmployeeDTO;
import com.example.springMVC.entities.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
