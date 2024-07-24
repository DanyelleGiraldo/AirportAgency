package com.airportagency.entities.airline.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlineService {
    private final AirlinesRepository airlinesRepository;
    
    public AirlineService(AirlinesRepository airlinesRepository){
        this.airlinesRepository = airlinesRepository;
    }

    public void createAirline(Airline airline){
        airlinesRepository.save(airline);
    }

    public void updateAirline(Airline airline){
        airlinesRepository.update(airline);
    }

    public Optional<Airline> getAirlineById(String id){
        return airlinesRepository.findById(id);
    }

    public void deleteAirline(String id){
        airlinesRepository.delete(id);
    }

    public List<Airline> getAllAirlines(){
        return airlinesRepository.findAll();
    }
}
