package com.airportagency.entities.employee.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.employee.domain.entity.Employee;
import com.airportagency.entities.employee.domain.service.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(String id) {
        employeeRepository.delete(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
