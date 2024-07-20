package com.airportagency.entities.Gates.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Gates.domain.entity.Gates;

public interface GatesRepository {
    void save(Gates gate);
    void update(Gates gate);
    Optional<Gates> findById(String id);
    void delete(String id);
    List<Gates> findAll();
}
