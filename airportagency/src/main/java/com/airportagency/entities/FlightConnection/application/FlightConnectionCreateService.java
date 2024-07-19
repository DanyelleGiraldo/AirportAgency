package com.airportagency.entities.FlightConnection.application;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionCreateService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionCreateService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.save(flightConnection);
    }

    

}
