package com.airportagency.entities.TripBooking.application;

import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class TripBookingSerachFlightFareService {
    private final FlightFaresRepository flightFaresRepository;

    public TripBookingSerachFlightFareService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public Optional<FlightFares> getFlightFaresById(String id) {
        return flightFaresRepository.findById(id);
    }
}
