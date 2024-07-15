package com.airportagency.entities.Customer.application;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerUpdateService {
    private final CustomerRepository customerRepository;

    public CustomerUpdateService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void updateCustomer(Customer customer){
        customerRepository.update(customer);
    }

}
