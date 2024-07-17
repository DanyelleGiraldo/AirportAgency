package com.airportagency.entities.employee.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.employee.domain.entity.Employee;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    Optional<Employee> findById(String id);
    void delete(String id);
    List<Employee> findAll();
}
