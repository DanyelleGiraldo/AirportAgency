package com.airportagency.entities.FlightFares.application;

import java.util.List;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareDeleteService {
    private final FlightFaresRepository flightFaresRepository;

    public FlightFareDeleteService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public void deleteFlighFare(String id){
        flightFaresRepository.delete(id);
    }

    public List<FlightFares> getAllFlightFares(){
        return flightFaresRepository.findAll();
    }
}
