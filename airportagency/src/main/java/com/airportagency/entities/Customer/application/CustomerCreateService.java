package com.airportagency.entities.Customer.application;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerCreateService {
    private final CustomerRepository customerRepository;

    public CustomerCreateService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
