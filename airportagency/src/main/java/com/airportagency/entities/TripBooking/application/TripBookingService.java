package com.airportagency.entities.TripBooking.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;
import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;
import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;
import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;
import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;
import com.airportagency.entities.Trip.domain.entity.Trip;
import com.airportagency.entities.Trip.domain.service.TripRepository;
import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;
import com.airportagency.entities.tripbookindetails.domain.entity.TripBookingDetails;
import com.airportagency.entities.tripbookindetails.domain.service.TripBookingDetailsRepository;

public class TripBookingService {
    private final TripRepository tripRepository;
    private final CustomerRepository customerRepository;
    private final TripBookingRepository tripBookingRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final FlightFaresRepository flightFaresRepository;
    private final TripBookingDetailsRepository tripBookingDetailsRepository;
    private final FlightConnectionRepository flightConnectionRepository;
    private final PlaneRepository planeRepository;
    
    

    

    public TripBookingService(TripRepository tripRepository, CustomerRepository customerRepository,
            TripBookingRepository tripBookingRepository, BookingStatusRepository bookingStatusRepository,
            FlightFaresRepository flightFaresRepository, TripBookingDetailsRepository tripBookingDetailsRepository,
            FlightConnectionRepository flightConnectionRepository, PlaneRepository planeRepository) {
        this.tripRepository = tripRepository;
        this.customerRepository = customerRepository;
        this.tripBookingRepository = tripBookingRepository;
        this.bookingStatusRepository = bookingStatusRepository;
        this.flightFaresRepository = flightFaresRepository;
        this.tripBookingDetailsRepository = tripBookingDetailsRepository;
        this.flightConnectionRepository = flightConnectionRepository;
        this.planeRepository = planeRepository;
    }

    public void createTripBooking(TripBooking tripBooking){
        tripBookingRepository.save(tripBooking);
    }

    public void updateTripBooking(TripBooking tripBooking){
        tripBookingRepository.update(tripBooking);

    }

    public Optional<TripBooking> getTripBookingById(String id){
        return tripBookingRepository.findById(id);
    }

    // FlightConnection

    public Optional<FlightConnection> getFlightConnectionById(String id) {
        return flightConnectionRepository.findById(id);
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionRepository.findAll();
    }

    public Optional<FlightConnection> getFlightCOnnectionByTrip(String id){
        return flightConnectionRepository.findByTrip(id);
    }

    //Trip Booking Detailss

    public void createTripBookingDetails(TripBookingDetails tripBookingDetails){
        tripBookingDetailsRepository.save(tripBookingDetails);
    }

    public Optional<TripBookingDetails> getTripBookingDetailsById(String id) {
        return tripBookingDetailsRepository.findById(id);
    }

    public List<TripBookingDetails> getAllTripBookingDetails() {
        return tripBookingDetailsRepository.findAll();
    }

    // Flight Fares

    public void createFlighFareId(FlightFares flightFares) {
        flightFaresRepository.save(flightFares);
    }

    public Optional<FlightFares> getFlightFaresById(String id) {
        return flightFaresRepository.findById(id);
    }

    public List<FlightFares> getAllFlightFares() {
        return flightFaresRepository.findAll();
    }

    //  Customer

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    // Trip 

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public Optional<Trip> getTripById(String id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // BOOKIN STATUS

    public void createBookingStatus(BookingStatus bookingStatus) {
        bookingStatusRepository.save(bookingStatus);
    }

    public Optional<BookingStatus> getBookingStatusById(int id) {
        return bookingStatusRepository.findById(id);
    }

    public List<BookingStatus> getAllBookingStatuses() {
        return bookingStatusRepository.findAll();
    }

    public List<String> getAllBookingStatusesStr() {
        return tripBookingRepository.findAllBookingTypes();
    }
    


    //

    public void deleteTripBooking(String id){
        tripBookingRepository.delete(id);
    }

    public List<TripBooking> getAllTripBookings(){
        return tripBookingRepository.findAll();
    }

    // CLIENTES

    public void createClient(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    // AVIONES

    public List<Plane> getAllAirplanes() {
        return planeRepository.findAll();
    }

    public Optional<Plane> getPlaneById(String id) {
        return planeRepository.findById(id);
    }

    public int getCapacity(String id) {
        return planeRepository.getMaxCapacity(id);
    }

    public void cancelTripBooking(String id) {
        tripBookingRepository.cancelBooking(id);
    }
}
