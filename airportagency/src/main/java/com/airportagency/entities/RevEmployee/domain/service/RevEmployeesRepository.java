package com.airportagency.entities.RevEmployee.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.RevEmployee.domain.entity.RevEmployees;

public interface RevEmployeesRepository {
    void save(RevEmployees revEmployees);
    void update(RevEmployees revEmployees);
    Optional<RevEmployees> findById(String id);
    void delete(String id);
    List<RevEmployees> findAll();
}
