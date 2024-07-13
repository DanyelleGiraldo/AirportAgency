package com.airportagency.entities.airline.application;

import java.util.Optional;

import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineSearchService {
    private final AirlinesRepository airlinesRepository;
    
    
    public AirlineSearchService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }


    public Optional<Airline> getAirlineById(String id){
        return airlinesRepository.findById(id);
    }

}
