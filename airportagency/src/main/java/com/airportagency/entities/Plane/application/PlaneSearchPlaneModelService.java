package com.airportagency.entities.Plane.application;

import java.util.Optional;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneSearchPlaneModelService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneSearchPlaneModelService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public Optional<PlaneModels> findByIdModel(String id){
        return planeModelRepository.findById(id);
    }
}
