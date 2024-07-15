package com.airportagency.entities.City.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.City.domain.entity.City;

public interface CityRepository {
    void save(City city);
    void update(City city);
    Optional<City> findById(String id);
    void delete(String id);
    List<City> findAll();
}
