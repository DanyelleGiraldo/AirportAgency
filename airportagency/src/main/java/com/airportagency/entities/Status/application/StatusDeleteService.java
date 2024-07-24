package com.airportagency.entities.Status.application;

import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusDeleteService {
    private final StatusRepository statusRepository;

    public StatusDeleteService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void deleteStatus(String id){
        statusRepository.delete(id);
    }
}
