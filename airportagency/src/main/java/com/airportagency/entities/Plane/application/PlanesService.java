package com.airportagency.entities.Plane.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;
import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Plane.domain.service.PlaneRepository;
import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;
import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;



public class PlanesService {
    private final StatusRepository statusRepository;
    private final PlaneRepository planesRepository;
    private final ManufacturesRepository manufacturesRepository;
    private final PlaneModelRepository planeModelsRepository;

    public PlanesService(PlaneRepository planesRepository, PlaneModelRepository planeModelsRepository, StatusRepository statusRepository, ManufacturesRepository manufacturesRepository){
        this.planesRepository = planesRepository;
        this.planeModelsRepository = planeModelsRepository; 
        this.statusRepository = statusRepository;
        this.manufacturesRepository = manufacturesRepository;
    }

    public void createPlanes(Plane planes){
        planesRepository.save(planes);
    }

    public void updatePlanes(Plane planes){
        planesRepository.update(planes);
    }

    public Optional<Plane> findById(String id){
        return planesRepository.findById(id);
    }

    public void deletePlanes(String id){
        planesRepository.delete(id);
    }

    public List<Plane> findAll(){
        return planesRepository.findAll();
    }

    // PLANE MODELS

    public void createPlaneModels(PlaneModels planeModels){
        planeModelsRepository.save(planeModels);
    }

    public List<PlaneModels> findAllModels(){
        return planeModelsRepository.findAll();
    }

    public Optional<PlaneModels> findByIdModel(String id){
        return planeModelsRepository.findById(id);
    }

    // STATUSES

    public void createStatus(Status status){
        statusRepository.save(status);
    }

    public Optional<Status> getStatusById(String id){
        return statusRepository.findById(id);
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }

    // MANUFACTURES

    public void createManufacturer(Manufactures manufacture){
        manufacturesRepository.save(manufacture);
    }

    public Optional<Manufactures> getManufacturerById(String id){
        return manufacturesRepository.findById(id);
    }

    public List<Manufactures> getAllManufactures(){
        return manufacturesRepository.findAll();
    }


}

