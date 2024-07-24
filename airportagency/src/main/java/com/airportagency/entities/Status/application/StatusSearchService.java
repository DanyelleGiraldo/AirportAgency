package com.airportagency.entities.Status.application;

import java.util.Optional;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusSearchService {
    private final StatusRepository statusRepository;

    public StatusSearchService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Optional<Status> getStatusById(String id){
        return statusRepository.findById(id);
    }
}
