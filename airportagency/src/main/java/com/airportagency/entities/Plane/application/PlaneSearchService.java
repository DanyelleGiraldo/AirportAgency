package com.airportagency.entities.Plane.application;

import java.util.Optional;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class PlaneSearchService {
    private final PlaneRepository planeRepository;

    public PlaneSearchService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Optional<Plane> getPlaneById(String id){
        return planeRepository.findById(id);
    }
}
