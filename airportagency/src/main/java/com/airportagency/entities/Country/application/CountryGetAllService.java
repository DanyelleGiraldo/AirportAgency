package com.airportagency.entities.Country.application;

import java.util.List;

import com.airportagency.entities.Country.domain.entity.Country;
import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountryGetAllService {
    private final CountryRepository countryRepository;

    public CountryGetAllService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
