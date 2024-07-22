package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;

public class TripBookingGetAllFlightConnectionService {

    private final FlightConnectionRepository flightConnectionRepository;

     public TripBookingGetAllFlightConnectionService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionRepository.findAll();
    }
}
