package com.airportagency.entities.Plane.application;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class PlaneCreateService {
    private final PlaneRepository planeRepository;

    public PlaneCreateService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public void createPlane(Plane plane){
        planeRepository.save(plane);
    }
}
