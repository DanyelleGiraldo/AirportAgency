package com.airportagency.entities.Plane.application;

import java.util.List;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class PlaneGetAllStatusService {
    private final StatusRepository statusRepository;

    public PlaneGetAllStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }
}
