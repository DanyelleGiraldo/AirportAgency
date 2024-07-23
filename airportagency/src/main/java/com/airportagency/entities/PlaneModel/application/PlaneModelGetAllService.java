package com.airportagency.entities.PlaneModel.application;

import java.util.List;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelGetAllService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneModelGetAllService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public List<PlaneModels> getAllPlaneModels(){
        return planeModelRepository.findAll();
    }
}
