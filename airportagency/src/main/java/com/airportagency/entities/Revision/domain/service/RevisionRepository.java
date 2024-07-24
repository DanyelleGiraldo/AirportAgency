package com.airportagency.entities.Revision.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Revision.domain.entity.Revision;

public interface RevisionRepository {
    void save(Revision revision);
    void update(Revision revision);
    Optional<Revision> findById(String id);
    void delete(String id);
    List<Revision> findAll(); 
}
