package com.airportagency.entities.City.application;

import com.airportagency.entities.City.domain.entity.City;
import com.airportagency.entities.City.domain.service.CityRepository;

public class CityCreateService {
    private final CityRepository cityRepository;

    public CityCreateService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void createCity(City city) {
        cityRepository.save(city);
    }
}
