package com.airportagency.entities.airport.application;

import java.util.Optional;

import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportSearchService {
    private final Airportrepository airportrepository;

    public AirportSearchService(Airportrepository airportrepository) {
        this.airportrepository = airportrepository;
    }

    public Optional<Airport> getAirportById(String id){
        return airportrepository.findById(id);
    }
}
