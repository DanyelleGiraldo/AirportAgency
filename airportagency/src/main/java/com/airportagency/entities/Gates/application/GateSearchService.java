package com.airportagency.entities.Gates.application;

import java.util.Optional;

import com.airportagency.entities.Gates.domain.entity.Gates;
import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateSearchService {
        private final GatesRepository gatesRepository;

        public GateSearchService(GatesRepository gatesRepository) {
            this.gatesRepository = gatesRepository;
        }
        
        public Optional<Gates> getGateById(String id){
        return gatesRepository.findById(id);
        }
}
