package com.airportagency.entities.airline.application;

import java.util.List;

import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineGetAllService {
    private final AirlinesRepository airlinesRepository;
    
    public AirlineGetAllService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    public List<Airline> getAllAirlines(){
        return airlinesRepository.findAll();
    }
}
