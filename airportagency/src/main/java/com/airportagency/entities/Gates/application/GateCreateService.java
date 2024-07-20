package com.airportagency.entities.Gates.application;

import com.airportagency.entities.Gates.domain.entity.Gates;
import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateCreateService {
        private final GatesRepository gatesRepository;

        public GateCreateService(GatesRepository gatesRepository) {
            this.gatesRepository = gatesRepository;
        }

        public void createGate(Gates gates){
        gatesRepository.save(gates);
        }
}
