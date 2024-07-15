package com.airportagency.entities.Country.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Country.domain.entity.Country;

public interface CountryRepository {
    void save(Country country);
    void update(Country country);
    Optional<Country> findById(String id);
    void delete(String id);
    List<Country> findAll();
}
