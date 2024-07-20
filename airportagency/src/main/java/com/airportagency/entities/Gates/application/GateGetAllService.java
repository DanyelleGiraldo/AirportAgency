package com.airportagency.entities.Gates.application;

import java.util.List;

import com.airportagency.entities.Gates.domain.entity.Gates;
import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateGetAllService {
        private final GatesRepository gatesRepository;

        public GateGetAllService(GatesRepository gatesRepository) {
            this.gatesRepository = gatesRepository;
        }
        
        public List<Gates> getAllGates(){
            return gatesRepository.findAll();
        }
}
