package com.airportagency.entities.TripBooking.application.trip;

import java.util.List;

public class TripBookingGetAllTripService {
    private final TripRepository tripRepository;

    public TripBookingGetAllTripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
