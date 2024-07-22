package com.airportagency.entities.TripBooking.application.plane;

import java.util.List;

public class TripBookingGetAllPlanesService {
    private final PlanesRepository planesRepository;

    public TripBookingGetAllPlanesService(PlanesRepository planesRepository) {
        this.planesRepository = planesRepository;
    }

    public List<Planes> getAllAirplanes() {
        return planesRepository.findAll();
    }
}   
