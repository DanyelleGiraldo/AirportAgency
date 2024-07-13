package com.airportagency.entities.airport.application;

import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportDeleteService {
    private final Airportrepository airportrepository;

    public AirportDeleteService(Airportrepository airportrepository) {
        this.airportrepository = airportrepository;
    }

    public void DeleteAirport(String id){
        airportrepository.delete(id);
    }
}
