package com.airportagency.entities.FlightFares.application;

import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareSerchService {
    private final FlightFaresRepository flightFaresRepository;

    public FlightFareSerchService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public Optional<FlightFares> getFlightFareById(String id){
        return flightFaresRepository.findById(id);
    }
}
