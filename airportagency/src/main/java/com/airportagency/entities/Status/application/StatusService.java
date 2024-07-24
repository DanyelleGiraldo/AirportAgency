package com.airportagency.entities.Status.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }


    public void createStatus(Status status){
        statusRepository.save(status);
    }

    public void updateStatus(Status status){
        statusRepository.update(status);
    }

    public Optional<Status> getStatusById(String id){
        return statusRepository.findById(id);
    }

    public void deleteStatus(String id){
        statusRepository.delete(id);
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }
}
