package com.airportagency.entities.City.application;

import java.util.Optional;

import com.airportagency.entities.City.domain.entity.City;
import com.airportagency.entities.City.domain.service.CityRepository;

public class CitySearchService {
    private final CityRepository cityRepository;

    public CitySearchService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    
    public Optional<City> getCityById(String id) {
        return cityRepository.findById(id);
    }
}
