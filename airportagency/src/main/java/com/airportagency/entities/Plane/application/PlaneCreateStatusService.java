package com.airportagency.entities.Plane.application;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class PlaneCreateStatusService {
    private final StatusRepository statusRepository;

    public PlaneCreateStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void createStatus(Status status){
        statusRepository.save(status);
    }
}
