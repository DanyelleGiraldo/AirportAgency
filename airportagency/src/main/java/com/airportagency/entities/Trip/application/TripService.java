package com.airportagency.entities.Trip.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;
import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;
import com.airportagency.entities.Trip.domain.entity.Trip;
import com.airportagency.entities.Trip.domain.service.TripRepository;
import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;
import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class TripService {
    private final TripRepository tripRepository;
    private final BookingStatusRepository bookingStatusRepository;
    private final TripBookingRepository tripBookingRepository;
    private final Airportrepository airportRepository;
    private final CustomerRepository customerRepository;


    public TripService(TripRepository tripRepository, BookingStatusRepository bookingStatusRepository, TripBookingRepository tripBookingRepository,
    Airportrepository airportRepository, CustomerRepository customerRepository) {
        this.tripRepository = tripRepository;
        this.bookingStatusRepository = bookingStatusRepository;
        this.tripBookingRepository = tripBookingRepository;
        this.airportRepository = airportRepository;
        this.customerRepository = customerRepository;
    }

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void updateTrip(Trip trip) {
        tripRepository.update(trip);
    }

    public Optional<Trip> getTripById(String id) {
        return tripRepository.findById(id);
    }

    // BOOKIN STATUS

    public void createBookingStatus(BookingStatus bookingStatus) {
        bookingStatusRepository.save(bookingStatus);
    }

    public Optional<BookingStatus> getBookingStatusById(int id) {
        return bookingStatusRepository.findById(id);
    }

    public List<BookingStatus> getAllBookingStatuss() {
        return bookingStatusRepository.findAll();
    }
    
    // TRIP BOOKING

    public void createTripBooking(TripBooking tripBooking){
        tripBookingRepository.save(tripBooking);
    }

    public Optional<TripBooking> getTripBookingById(String id){
        return tripBookingRepository.findById(id);
    }

    public List<TripBooking> getAllTripBookings(){
        return tripBookingRepository.findAll();
    }


    //

    public void deleteTrip(String id) {
        tripRepository.delete(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    // getTripsByParameters()

    public Optional<List<Trip>> getTripsByParameters(LocalDate tripDate, String idCityA, String idCityB){
        return tripRepository.findByParameters(tripDate, idCityA, idCityB);
    }
}
