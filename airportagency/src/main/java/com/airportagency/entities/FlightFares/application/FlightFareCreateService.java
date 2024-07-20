package com.airportagency.entities.FlightFares.application;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareCreateService {
    private final FlightFaresRepository flightFaresRepository;

    public FlightFareCreateService(FlightFaresRepository flightFaresRepository){
        this.flightFaresRepository = flightFaresRepository;
    }

    public void createFlightFare(FlightFares flightFares){
        flightFaresRepository.save(flightFares);
    }
}
