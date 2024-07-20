package com.airportagency.entities.FlightFares.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;

public interface FlightFaresRepository {
    void save(FlightFares flightFares);
    void update(FlightFares flightFares);
    Optional<FlightFares> findById(String id);
    void delete(String id);
    List<FlightFares> findAll();
}
