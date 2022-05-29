package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(String Id) {
        employeeRepository.deleteById(Id);
    }

    @Override
    public Optional<Employee> getEmployeeById(String Id) {
        return employeeRepository.findById(Id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
