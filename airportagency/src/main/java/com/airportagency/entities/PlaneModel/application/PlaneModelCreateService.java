package com.airportagency.entities.PlaneModel.application;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelCreateService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneModelCreateService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public void createPlaneModel(PlaneModels planeModels){
        planeModelRepository.save(planeModels);
    }
}
