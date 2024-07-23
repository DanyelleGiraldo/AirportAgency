package com.airportagency.entities.PlaneModel.application;

import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelDeleteService {
    private final PlaneModelRepository planeModelRepository;

    public PlaneModelDeleteService(PlaneModelRepository planeModelRepository) {
        this.planeModelRepository = planeModelRepository;
    }

    public void deletePlaneModel(String id){
        planeModelRepository.delete(id);
    }
}
