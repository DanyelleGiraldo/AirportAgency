package com.airportagency.entities.Status.application;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusCreateService {
    private final StatusRepository statusRepository;

    public StatusCreateService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void createStatus(Status status){
        statusRepository.save(status);
    }
}
