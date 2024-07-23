package com.airportagency.entities.PlaneModel.application;

import java.util.Optional;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelSearchService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneModelSearchService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public Optional<PlaneModels> getPlaneModelById(String id){
        return planeModelRepository.findById(id);
    }
}
