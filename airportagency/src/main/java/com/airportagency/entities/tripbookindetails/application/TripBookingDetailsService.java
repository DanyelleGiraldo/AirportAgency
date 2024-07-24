package com.airportagency.entities.tripbookindetails.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;
import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;
import com.airportagency.entities.Trip.domain.entity.Trip;
import com.airportagency.entities.Trip.domain.service.TripRepository;
import com.airportagency.entities.tripbookindetails.domain.entity.TripBookingDetails;
import com.airportagency.entities.tripbookindetails.domain.service.TripBookingDetailsRepository;

public class TripBookingDetailsService {
    private final TripBookingDetailsRepository tripBookingDetailsRepository;
    private final TripRepository tripRepository;
    private final CustomerRepository customerRepository;
    private final FlightFaresRepository flightFaresRepository;

    public TripBookingDetailsService(TripBookingDetailsRepository tripBookingDetailsRepository, TripRepository tripRepository, CustomerRepository customerRepository, FlightFaresRepository flightFaresRepository){
        this.tripBookingDetailsRepository = tripBookingDetailsRepository;
        this.tripRepository = tripRepository;
        this.customerRepository = customerRepository;
        this.flightFaresRepository = flightFaresRepository;
        
    }

    public void createTripBookingDetails(TripBookingDetails tripBookingDetails){
        tripBookingDetailsRepository.save(tripBookingDetails);
    }

    public void updateTripBookingDetails(TripBookingDetails tripBookingDetails){
        tripBookingDetailsRepository.update(tripBookingDetails);
    }

    public Optional<TripBookingDetails> getTripBookingDetailsById(String id){
        return tripBookingDetailsRepository.findById(id);
    }


    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }



    public void createFlightFares(FlightFares flightFares) {
        flightFaresRepository.save(flightFares);
    }

    public Optional<FlightFares> getFlightFaresById(String id) {
        return flightFaresRepository.findById(id);
    }

    public List<FlightFares> getAllFlightFares() {
        return flightFaresRepository.findAll();
    }




    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public Optional<Trip> getTripById(String id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    public void deleteTripBookingDetails(String id){
        tripBookingDetailsRepository.delete(id);
    }

    public List<TripBookingDetails> getAllTripBookingDetails(){
        return tripBookingDetailsRepository.findAll();
    }
}
