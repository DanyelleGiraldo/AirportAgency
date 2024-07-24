package com.airportagency.entities.Customer.application;

import java.util.List;
import java.util.Optional;


import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }


    public void deleteCustomer(String id) {
        customerRepository.delete(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
