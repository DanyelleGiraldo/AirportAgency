package com.airportagency.entities.Customer.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Customer.domain.entity.Customer;

public interface CustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    Optional<Customer> findById(String id);
    void delete(String id);
    List<Customer> findAll();
}
