package com.airportagency.entities.employee.application;

import com.airportagency.entities.employee.domain.entity.Employee;
import com.airportagency.entities.employee.domain.service.EmployeeRepository;

public class EmployeeUpdateService {
    private final EmployeeRepository employeeRepository;

    public EmployeeUpdateService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void updateEmployee(Employee employee){
        employeeRepository.update(employee);
    }
}
