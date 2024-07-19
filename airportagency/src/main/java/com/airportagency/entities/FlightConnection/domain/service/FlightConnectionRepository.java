package com.airportagency.entities.FlightConnection.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;

public interface FlightConnectionRepository {
    void save(FlightConnection flightConnection);
    void update(FlightConnection flightConnection);
    Optional<FlightConnection> findById(String id);
    void delete(String id);
    List<FlightConnection> findAll();
    Optional<FlightConnection> findByTrip(String id);
}