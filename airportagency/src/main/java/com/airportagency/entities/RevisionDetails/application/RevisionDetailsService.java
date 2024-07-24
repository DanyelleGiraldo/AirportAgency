package com.airportagency.entities.RevisionDetails.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.RevisionDetails.domain.entity.RevisionDetails;
import com.airportagency.entities.RevisionDetails.domain.service.RevisionDetailsRepository;

public class RevisionDetailsService {
    private final RevisionDetailsRepository revisionDetailsRepository;

    public RevisionDetailsService(RevisionDetailsRepository revisionDetailsRepository) {
        this.revisionDetailsRepository = revisionDetailsRepository;
    }

    public void createRevisionDetail(RevisionDetails revisionDetails){
        revisionDetailsRepository.save(revisionDetails);
    }

    public void updateRevisionDetail(RevisionDetails revisionDetails){
        revisionDetailsRepository.update(revisionDetails);
    }

    public Optional<RevisionDetails> findById(String id){
        return revisionDetailsRepository.findById(id);
    }

    public void deleteRevisionDetails(String id){
        revisionDetailsRepository.delete(id);
    }

    public List<RevisionDetails> findAll(){
        return revisionDetailsRepository.findAll();
    }
}
