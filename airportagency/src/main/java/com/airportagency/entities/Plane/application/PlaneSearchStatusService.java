package com.airportagency.entities.Plane.application;

import java.util.Optional;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class PlaneSearchStatusService {
    private final StatusRepository statusRepository;

    public PlaneSearchStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Optional<Status> getStatusById(String id){
        return statusRepository.findById(id);
    }
}
