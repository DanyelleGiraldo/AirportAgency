package com.airportagency.entities.TripBooking.application.plane;

import java.util.Optional;

public class TripBookingSearchPlaneService {
    private final PlanesRepository planesRepository;
    
    public TripBookingSearchPlaneService(PlanesRepository planesRepository) {
        this.planesRepository = planesRepository;
    }

    public Optional<Planes> getPlaneById(String id) {
        return planesRepository.findById(id);
    }
}
