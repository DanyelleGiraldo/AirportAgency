package com.airportagency.entities.Manufactures.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;

public interface ManufacturesRepository {
    void save(Manufactures manufacture);
    void update(Manufactures manufacture);
    Optional<Manufactures> findById(String id);
    void delete(String id);
    List<Manufactures> findAll();
}
