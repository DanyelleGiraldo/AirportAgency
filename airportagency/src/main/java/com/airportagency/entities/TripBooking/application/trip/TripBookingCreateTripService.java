package com.airportagency.entities.TripBooking.application.trip;

public class TripBookingCreateTripService {
    private final TripRepository tripRepository;

    public TripBookingCreateTripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }
}
