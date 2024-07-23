package com.airportagency.entities.Plane.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Plane.domain.entity.Plane;

public interface PlaneRepository {
    void save(Plane planes);
    void update(Plane planes);
    Optional<Plane> findById(String id);
    void delete(String id);
    List<Plane> findAll();
    int getMaxCapacity(String id);
}
