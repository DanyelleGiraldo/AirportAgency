package com.airportagency.entities.Customer.application;

import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerDeleteService {
    private final CustomerRepository customerRepository;

    public CustomerDeleteService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public void deleteCustomer(String id){
        customerRepository.delete(id);
    }
}
