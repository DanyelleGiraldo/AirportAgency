package com.airportagency.entities.TripBooking.application.trip;

import java.util.Optional;

public class TripBookingSearchTripService {
    private final TripRepository tripRepository;

    public TripBookingSearchTripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Optional<Trip> getTripById(String id) {
        return tripRepository.findById(id);
    }

}
