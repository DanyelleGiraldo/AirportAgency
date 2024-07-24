package com.airportagency.entities.Plane.application;

import java.util.List;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneGetAllPlaneModelsService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneGetAllPlaneModelsService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public List<PlaneModels> findAllModels(){
        return planeModelRepository.findAll();
    }
}
