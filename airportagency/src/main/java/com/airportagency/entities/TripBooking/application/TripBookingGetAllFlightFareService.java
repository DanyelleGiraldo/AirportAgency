package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class TripBookingGetAllFlightFareService {
    private final FlightFaresRepository flightFaresRepository;

    public TripBookingGetAllFlightFareService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public List<FlightFares> getAllFlightFares() {
        return flightFaresRepository.findAll();
    }
}
