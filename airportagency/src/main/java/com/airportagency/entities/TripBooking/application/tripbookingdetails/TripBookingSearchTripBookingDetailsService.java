package com.airportagency.entities.TripBooking.application.tripbookingdetails;

import java.util.Optional;

import com.airportagency.entities.FlightFares.domain.entity.FlightFares;

public class TripBookingSearchTripBookingDetailsService {
    private final TripBookingDetailsRepository tripBookingDetailsRepository;

    public TripBookingSearchTripBookingDetailsService(TripBookingDetailsRepository tripBookingDetailsRepository) {
        this.tripBookingDetailsRepository = tripBookingDetailsRepository;
    }

    public Optional<FlightFares> getFlightFaresById(String id) {
        return flightFaresRepository.findById(id);
    }
}
