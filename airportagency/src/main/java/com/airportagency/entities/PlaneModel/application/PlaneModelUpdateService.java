package com.airportagency.entities.PlaneModel.application;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelUpdateService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneModelUpdateService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public void updatePlaneModel(PlaneModels planeModels){
        planeModelRepository.update(planeModels);
    }
}
