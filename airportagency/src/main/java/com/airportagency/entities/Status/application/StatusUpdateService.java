package com.airportagency.entities.Status.application;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusUpdateService {
    private final StatusRepository statusRepository;

    public StatusUpdateService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void updateStatus(Status status){
        statusRepository.update(status);
    }
}
