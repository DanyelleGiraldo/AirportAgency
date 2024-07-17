package com.airportagency.entities.employee.application;

import java.util.List;

import com.airportagency.entities.employee.domain.entity.Employee;
import com.airportagency.entities.employee.domain.service.EmployeeRepository;

public class EmployeeGetAllService {
    private final EmployeeRepository employeeRepository;

    public EmployeeGetAllService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
