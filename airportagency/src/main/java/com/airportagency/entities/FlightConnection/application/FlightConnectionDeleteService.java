package com.airportagency.entities.FlightConnection.application;

import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionDeleteService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionDeleteService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void deleteFlightConnection(String id) {
        flightConnectionRepository.delete(id);
    }
}
