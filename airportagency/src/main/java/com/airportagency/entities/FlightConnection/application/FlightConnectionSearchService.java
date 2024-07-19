package com.airportagency.entities.FlightConnection.application;

import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionSearchService {

    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionSearchService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public Optional<FlightConnection> getFlightConnectionById(String id) {
        return flightConnectionRepository.findById(id);
    }
}
