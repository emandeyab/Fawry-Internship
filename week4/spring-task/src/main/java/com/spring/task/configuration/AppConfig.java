package com.spring.task.configuration;

import com.spring.task.services.EmployeeService;
import com.spring.task.services.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    EmployeeService employeeService(){
        return new EmployeeServiceImpl();
    }
}
