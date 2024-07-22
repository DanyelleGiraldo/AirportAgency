package com.airportagency.entities.TripBooking.application;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class TripBookingCreateClientService {
    private final CustomerRepository customerRepository;

    public TripBookingCreateClientService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createClient(Customer customer) {
        customerRepository.save(customer);
    }
}
