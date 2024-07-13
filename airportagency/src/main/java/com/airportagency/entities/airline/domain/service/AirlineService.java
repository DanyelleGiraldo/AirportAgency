package com.airportagency.entities.airline.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.airline.domain.entity.Airline;

public interface AirlineService {
    void save(Airline airline);
    void update(Airline airline);
    Optional<Airline> findById(String id);
    void delete(String id);
    List<Airline> findAll();
}
