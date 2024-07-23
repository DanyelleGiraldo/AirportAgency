package com.airportagency.entities.Plane.application;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class PlaneUpdateService {
    private final PlaneRepository planeRepository;

    public PlaneUpdateService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }
    
    public void updatePlane(Plane plane){
        planeRepository.update(plane);
    }
}
