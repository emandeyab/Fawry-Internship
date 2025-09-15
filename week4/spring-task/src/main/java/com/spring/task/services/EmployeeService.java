package com.spring.task.services;

import com.spring.task.models.Employee;

import java.util.Map;

public interface EmployeeService {

        Map<Integer, Employee> getEmployee();
        public Employee getEmpById(int id);
        public void addEmp(Employee employee);
        public void updateEmp(Employee employee);
        public boolean deleteEmp(int id);
}
