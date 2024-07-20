package com.airportagency.entities.Gates.application;

import com.airportagency.entities.Gates.domain.entity.Gates;
import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateUpdateService {
        private final GatesRepository gatesRepository;

        public GateUpdateService(GatesRepository gatesRepository) {
            this.gatesRepository = gatesRepository;
        }

        public void updateGate(Gates gates){
            gatesRepository.update(gates);
        }
}
