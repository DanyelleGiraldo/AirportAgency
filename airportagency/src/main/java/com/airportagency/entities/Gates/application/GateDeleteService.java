package com.airportagency.entities.Gates.application;

import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateDeleteService {
        private final GatesRepository gatesRepository;

        public GateDeleteService(GatesRepository gatesRepository) {
            this.gatesRepository = gatesRepository;
        }

        public void deleteGates(String id){
            gatesRepository.delete(id);
        }
}
