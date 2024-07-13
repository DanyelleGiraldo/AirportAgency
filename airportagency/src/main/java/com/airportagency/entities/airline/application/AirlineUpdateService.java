package com.airportagency.entities.airline.application;

import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineUpdateService {
    private final AirlinesRepository airlinesRepository;
    
    public AirlineUpdateService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    public void updateAirline(Airline airline){
            airlinesRepository.update(airline);
    }
}
