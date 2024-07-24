package com.airportagency.entities.Gates.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Gates.domain.entity.Gates;
import com.airportagency.entities.Gates.domain.service.GatesRepository;

public class GateService {
    private final GatesRepository gatesRepository;

    public GateService(GatesRepository gatesRepository){
        this.gatesRepository = gatesRepository;
    }

    public void createGate(Gates gates){
        gatesRepository.save(gates);
    }

    public void updateGate(Gates gates){
        gatesRepository.update(gates);
    }

    public Optional<Gates> getGateById(String id){
        return gatesRepository.findById(id);
    }

    public void deleteGates(String id){
        gatesRepository.delete(id);
    }

    public List<Gates> getAllGates(){
        return gatesRepository.findAll();
    }
}
