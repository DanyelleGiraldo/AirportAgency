package com.airportagency.entities.Country.application;

import java.util.Optional;

import com.airportagency.entities.Country.domain.entity.Country;
import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountrySearchService {
    private final CountryRepository countryRepository;

    public CountrySearchService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional<Country> getCountryById(String id) {
        return countryRepository.findById(id);
    }
}
