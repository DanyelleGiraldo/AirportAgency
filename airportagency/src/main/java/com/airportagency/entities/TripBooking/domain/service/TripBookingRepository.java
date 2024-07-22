package com.airportagency.entities.TripBooking.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.TripBooking.domain.entity.TripBooking;

public interface TripBookingRepository {
    void save(TripBooking tripBooking);
    void update(TripBooking tripBooking);
    Optional<TripBooking> findById(String id);
    void delete(String id);
    List<TripBooking> findAll();
    Optional<FlightFares> findFlightFareByTripBId(String id);
    List<String> findAllBookingTypes(); 
    Optional<Integer> getBookingStatus(String id);
    void cancelBooking(String id);
    void confirmBooking(String id);
}
