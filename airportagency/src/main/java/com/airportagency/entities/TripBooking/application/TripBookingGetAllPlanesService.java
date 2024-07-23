package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class TripBookingGetAllPlanesService {
    private final PlaneRepository planeRepository;

    public TripBookingGetAllPlanesService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public List<Plane> getAllAirplanes() {
        return planeRepository.findAll();
    }
}   
