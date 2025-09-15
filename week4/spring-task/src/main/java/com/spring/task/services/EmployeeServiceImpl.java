package com.spring.task.services;

import com.spring.task.models.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    @Override
    public Map<Integer, Employee> getEmployee() {
        return employeeMap;
    }

    @Override
    public Employee getEmpById(int id) {
        if (employeeMap.containsKey(id)){
        return employeeMap.get(id);
        }
        else {
            System.out.println("Employee not found.");
            return null;
        }
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void updateEmp(Employee employee) {
        if(employeeMap.containsKey(employee.getId())){
            employeeMap.put(employee.getId(), employee);
            System.out.println("Employee updated successfully.");
        }
        else {
            System.out.println("Employee not found.");
        }
    }

    @Override
    public boolean deleteEmp(int id) {
        if(employeeMap.containsKey(id)){
            employeeMap.remove(id);
            System.out.println("Employee deleted successfully.");
            return true;
        }
        else {
            System.out.println("Employee not found.");
            return false;
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("EmployeeService bean initialized.");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("EmployeeService bean destroyed.");
    }
}
