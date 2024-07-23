package com.airportagency.entities.PlaneModel.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;

public interface  PlaneModelRepository {
    void save(PlaneModels models);
    void update(PlaneModels models);
    Optional<PlaneModels> findById(String id);
    void delete(String id);
    List<PlaneModels> findAll();
}
