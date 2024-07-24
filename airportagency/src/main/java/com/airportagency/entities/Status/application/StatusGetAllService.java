package com.airportagency.entities.Status.application;

import java.util.List;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusGetAllService {
    private final StatusRepository statusRepository;

    public StatusGetAllService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }
}
