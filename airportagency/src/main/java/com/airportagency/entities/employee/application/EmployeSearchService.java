package com.airportagency.entities.employee.application;

import java.util.Optional;

import com.airportagency.entities.employee.domain.entity.Employee;
import com.airportagency.entities.employee.domain.service.EmployeeRepository;

public class EmployeSearchService {
    private final EmployeeRepository employeeRepository;

    public EmployeSearchService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> searchEmployee(String id){
        return employeeRepository.findById(id);
    }
}
