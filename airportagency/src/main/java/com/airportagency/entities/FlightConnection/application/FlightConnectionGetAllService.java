package com.airportagency.entities.FlightConnection.application;

import java.util.List;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionGetAllService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionGetAllService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionRepository.findAll();
    }
}
