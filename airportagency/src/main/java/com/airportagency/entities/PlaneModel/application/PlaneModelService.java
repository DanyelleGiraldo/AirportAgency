package com.airportagency.entities.PlaneModel.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelService {
    private final PlaneModelRepository planeModelsRepository;

    public PlaneModelService(PlaneModelRepository planeModelsRepository) {
        this.planeModelsRepository = planeModelsRepository;
    }

    public void createPlaneModels(PlaneModels planeModels){
        planeModelsRepository.save(planeModels);
    }

    public void updatePlaneModels(PlaneModels planeModels){
        planeModelsRepository.update(planeModels);
    }

    public Optional<PlaneModels> findById(String id){
        return planeModelsRepository.findById(id);
    }

    public void deletePlaneModels(String id){
        planeModelsRepository.delete(id);
    }

    public List<PlaneModels> findAll(){
        return planeModelsRepository.findAll();
    }
}
