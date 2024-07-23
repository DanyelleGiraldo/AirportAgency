package com.airportagency.entities.Plane.application;

import java.util.List;

import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;

public class PlaneGetAllService {
    private final PlaneRepository planeRepository;

    public PlaneGetAllService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public List<Plane> getAllPlane(){
        return planeRepository.findAll();
    }
}
