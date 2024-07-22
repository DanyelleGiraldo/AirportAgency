package com.airportagency.entities.TripBooking.application;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class TripBookingCreateCustomerService {
    private final CustomerRepository customerRepository;

    public TripBookingCreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
