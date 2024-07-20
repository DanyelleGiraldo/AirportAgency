package com.airportagency.entities.FlightFares.application;

import java.util.List;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareGetAllService {
    private final FlightFaresRepository flightFaresRepository;

    public FlightFareGetAllService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public List<FlightFares> getAllFlightFares(){
        return flightFaresRepository.findAll();
    }
}
