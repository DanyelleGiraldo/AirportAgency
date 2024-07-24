package com.airportagency.entities.airport.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportService {
    private final Airportrepository airportRepository;

    public AirportService(Airportrepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }
    
    public void updateAirport(Airport airport) {
        airportRepository.update(airport);
    }

    public Optional<Airport> getAirportById(String id) {
        return airportRepository.findById(id);
    }

    public void deleteAirport(String id) {
        airportRepository.delete(id);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
