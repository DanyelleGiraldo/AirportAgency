package com.airportagency.entities.TripBooking.application;

import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class TripBookingGetFlightConnectionByTripService {
    private final FlightConnectionRepository flightConnectionRepository;

    public TripBookingGetFlightConnectionByTripService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public Optional<FlightConnection> getFlightCOnnectionByTrip(String id){
        return flightConnectionRepository.findByTrip(id);
    }
}
