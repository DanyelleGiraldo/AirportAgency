package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class TripBookingGetAllCustomerservice {
    private final CustomerRepository customerRepository;

    public TripBookingGetAllCustomerservice(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
