package com.airportagency.entities.employee.application;

import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class EmployeeDeleteService {
    private final CustomerRepository customerRepository;

    public EmployeeDeleteService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteEmployee(String id){
        customerRepository.delete(id);
    }
}
