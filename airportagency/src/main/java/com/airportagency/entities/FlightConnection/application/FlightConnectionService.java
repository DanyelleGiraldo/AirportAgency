package com.airportagency.entities.FlightConnection.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class FlightConnectionService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.save(flightConnection);
    }

    public void updateFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<FlightConnection> getFlightConnectionById(String id) {
        return flightConnectionRepository.findById(id);
    }
    
    public void deleteFlightConnection(String id) {
        flightConnectionRepository.delete(id);
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionRepository.findAll();
    }

    public Optional<FlightConnection> getFlightCOnnectionByTrip(String id){
        return flightConnectionRepository.findByTrip(id);
    }
}
