package com.airportagency.entities.Customer.application;

import java.util.Optional;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerSearchService {
    private final CustomerRepository customerRepository;

    public CustomerSearchService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(String id){
        return customerRepository.findById(id);
    }
}
