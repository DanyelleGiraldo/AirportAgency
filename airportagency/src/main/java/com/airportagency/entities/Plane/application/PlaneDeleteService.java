package com.airportagency.entities.Plane.application;

import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class PlaneDeleteService {
    private final PlaneRepository planeRepository;

    public PlaneDeleteService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public void deletePlane(String id){
        planeRepository.delete(id);
    }
}
