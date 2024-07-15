package com.airportagency.entities.City.application;

import com.airportagency.entities.City.domain.service.CityRepository;

public class CityDeleteService {
    private final CityRepository cityRepository;

    public CityDeleteService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    
    public void deleteCity(String id) {
        cityRepository.delete(id);
    }
}
