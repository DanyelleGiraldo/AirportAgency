package com.airportagency.entities.airport.application;

import java.util.List;

import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportGetAllService {
    private final Airportrepository airportrepository;

    public AirportGetAllService(Airportrepository airportrepository) {
        this.airportrepository = airportrepository;
    }

    public List<Airport> GetAllAirports(){
        return airportrepository.findAll();
    }
}
