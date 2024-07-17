package com.airportagency.entities.employee.application;

import com.airportagency.entities.employee.domain.entity.Employee;
import com.airportagency.entities.employee.domain.service.EmployeeRepository;

public class EmployeeCreateService {
    private final EmployeeRepository employeeRepository;

    public EmployeeCreateService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }
}
