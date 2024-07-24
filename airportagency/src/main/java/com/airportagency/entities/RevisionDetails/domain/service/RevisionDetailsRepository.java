package com.airportagency.entities.RevisionDetails.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.RevisionDetails.domain.entity.RevisionDetails;

public interface RevisionDetailsRepository {
    void save(RevisionDetails revisionDetails);
    void update(RevisionDetails revisionDetails);
    Optional<RevisionDetails> findById(String id);
    void delete(String id);
    List<RevisionDetails> findAll();
}
