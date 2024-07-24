package com.airportagency.entities.Plane.application;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneCreatePlaneModelsService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneCreatePlaneModelsService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public void createPlaneModels(PlaneModels planeModels){
        planeModelRepository.save(planeModels);
    }
}
