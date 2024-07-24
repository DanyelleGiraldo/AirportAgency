package com.airportagency.entities.RevEmployee.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.RevEmployee.domain.entity.RevEmployees;
import com.airportagency.entities.RevEmployee.domain.service.RevEmployeesRepository;

public class RevEmployeeService {
    private final RevEmployeesRepository revEmployeesRepository;

    public RevEmployeeService(RevEmployeesRepository revEmployeesRepository) {
        this.revEmployeesRepository = revEmployeesRepository;
    }

    public void createRevEmployee(RevEmployees revEmployee) {
        revEmployeesRepository.save(revEmployee);
    }

    public void updateRevEmployee(RevEmployees revEmployee) {
        revEmployeesRepository.update(revEmployee);
    }

    public Optional<RevEmployees> findById(String id) {
        return revEmployeesRepository.findById(id);
    }

    public void deleteRevEmployee(String id) {
        revEmployeesRepository.delete(id);
    }
    
    public List<RevEmployees> getAllRevEmployees() {
        return revEmployeesRepository.findAll();
    }
}
