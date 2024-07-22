package com.airportagency.entities.TripBooking.application.hechos;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.FlightFares.domain.service.FlightFaresRepository;

public class TripBookingCreateFlightFareService {
    private final FlightFaresRepository flightFaresRepository;

    public TripBookingCreateFlightFareService(FlightFaresRepository flightFaresRepository) {
        this.flightFaresRepository = flightFaresRepository;
    }

    public void createFlighFareId(FlightFares flightFares) {
        flightFaresRepository.save(flightFares);
    }
}
