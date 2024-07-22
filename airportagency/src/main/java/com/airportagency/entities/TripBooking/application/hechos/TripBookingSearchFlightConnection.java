package com.airportagency.entities.TripBooking.application.hechos;

import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class TripBookingSearchFlightConnection {
    private final FlightConnectionRepository flightConnectionRepository;

    public TripBookingSearchFlightConnection(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public Optional<FlightConnection> getFlightConnectionByTrip(String id){
        return flightConnectionRepository.findByTrip(id);
    }
    
}
