package com.airportagency.entities.airport.application;

import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportUpdateService {
    private final Airportrepository airportrepository;

    public AirportUpdateService(Airportrepository airportrepository) {
        this.airportrepository = airportrepository;
    }

    public void updateAirport(Airport airport){
        airportrepository.update(airport);
    }
}
