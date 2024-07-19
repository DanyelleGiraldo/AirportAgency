package com.airportagency.entities.FlightConnection.application;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionUpdateService {

    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionUpdateService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void updateFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.update(flightConnection);
    }

}
