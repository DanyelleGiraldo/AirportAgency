package com.airportagency.entities.TripBooking.application;

import java.util.Optional;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class TripBookingSearchPlaneService {
    private final PlaneRepository planeRepository;
    
    public TripBookingSearchPlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Optional<Plane> getPlaneById(String id) {
        return planeRepository.findById(id);
    }
}
