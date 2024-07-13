package com.airportagency.entities.airport.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.airport.domain.entity.Airport;

public interface Airportrepository {
    void save(Airport airport);
    void update(Airport airport);
    Optional<Airport> findById(String id);
    void delete(String id);
    List<Airport> findAll();
}
