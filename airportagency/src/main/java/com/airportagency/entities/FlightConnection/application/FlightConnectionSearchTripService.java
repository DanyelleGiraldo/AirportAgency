package com.airportagency.entities.FlightConnection.application;

import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionSearchTripService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionSearchTripService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public Optional<FlightConnection> getFlightConnectionByTrip(String id){
        return flightConnectionRepository.findByTrip(id);
    }
}
