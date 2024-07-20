package com.airportagency.entities.FlightFares.application;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareUpdateService {
    private final FlightFaresRepository flightFaresRepository;

    public FlightFareUpdateService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public void updateFlightFare(FlightFares flightFares){
        flightFaresRepository.update(flightFares);
    }
}
