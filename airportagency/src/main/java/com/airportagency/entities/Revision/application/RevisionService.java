package com.airportagency.entities.Revision.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Revision.domain.entity.Revision;
import com.airportagency.entities.Revision.domain.service.RevisionRepository;

public class RevisionService {
    private final RevisionRepository revisionRepository;

    public RevisionService(RevisionRepository revisionRepository){
        this.revisionRepository = revisionRepository;
    }

    public void createRevision(Revision revision){
        revisionRepository.save(revision);

    }

    public void updateRevisions(Revision revision){
        revisionRepository.update(revision);

    }

    public Optional <Revision> getRevisionById(String id){
        return revisionRepository.findById(id);
    }

    public void deleteRevision(String id) {
        revisionRepository.delete(id);
    }

    public List<Revision> getAllRevisions() {
        return revisionRepository.findAll();
    }
}
