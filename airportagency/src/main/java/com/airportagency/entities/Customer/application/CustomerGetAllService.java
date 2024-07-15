package com.airportagency.entities.Customer.application;

import java.util.List;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerGetAllService {
    private final CustomerRepository customerRepository;

    public CustomerGetAllService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
