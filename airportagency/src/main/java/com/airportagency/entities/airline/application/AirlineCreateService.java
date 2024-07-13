package com.airportagency.entities.airline.application;

import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineCreateService {
    private final AirlinesRepository airlinesRepository;
    
    public AirlineCreateService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    public void createAirline(Airline airline){
        airlinesRepository.save(airline);
    }
}
