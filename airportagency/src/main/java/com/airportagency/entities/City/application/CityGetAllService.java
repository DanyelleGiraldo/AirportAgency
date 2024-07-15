package com.airportagency.entities.City.application;

import java.util.List;

import com.airportagency.entities.City.domain.entity.City;
import com.airportagency.entities.City.domain.service.CityRepository;

public class CityGetAllService {
    private final CityRepository cityRepository;

    public CityGetAllService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
