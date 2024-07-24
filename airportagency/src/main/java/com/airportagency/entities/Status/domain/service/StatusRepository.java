package com.airportagency.entities.Status.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Status.domain.entity.Status;

public interface StatusRepository {
    void save(Status status);
    void update(Status status);
    Optional<Status> findById(String id);
    void delete(String id);
    List<Status> findAll();
}
