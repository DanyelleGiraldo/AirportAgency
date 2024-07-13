package com.airportagency.entities.airport.application;

import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportCreateService {
    private final Airportrepository airportrepository;

    public AirportCreateService(Airportrepository airportrepository) {
        this.airportrepository = airportrepository;
    }

    public void CreateAirport(Airport airport){
        airportrepository.save(airport);
    }

}
