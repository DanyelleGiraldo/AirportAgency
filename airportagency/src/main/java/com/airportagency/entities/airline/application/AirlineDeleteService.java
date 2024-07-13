package com.airportagency.entities.airline.application;

import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineDeleteService {
    private final AirlinesRepository airlinesRepository;

    public AirlineDeleteService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    public void deleteAirline(String id){
        airlinesRepository.delete(id);
    }
}
