package com.airportagency.entities.FlightFares.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class FlightFareService {
private final FlightFaresRepository flightFaresRepository;

    public FlightFareService(FlightFaresRepository flightFaresRepository){
        this.flightFaresRepository = flightFaresRepository;
    }

    public void createFlightFare(FlightFares flightFares){
        flightFaresRepository.save(flightFares);
    }

    public void updateFlightFare(FlightFares flightFares){
        flightFaresRepository.update(flightFares);
    }

    public Optional<FlightFares> getFlightFareById(String id){
        return flightFaresRepository.findById(id);
    }

    public void deleteFlighFare(String id){
        flightFaresRepository.delete(id);
    }

    public List<FlightFares> getAllFlightFares(){
        return flightFaresRepository.findAll();
    }
}
