package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void deleteEmployee(String id);
    Optional<Employee> getEmployeeById(String id);
    void createEmployee(Employee employee);
}

