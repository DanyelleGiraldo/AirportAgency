package com.airportagency.entities.City.application;

import com.airportagency.entities.City.domain.entity.City;
import com.airportagency.entities.City.domain.service.CityRepository;

public class CityUpdateService {
    private final CityRepository cityRepository;

    public CityUpdateService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void updateCity(City city) {
        cityRepository.update(city);
    }
}
