package com.airportagency.entities.Country.application;

import com.airportagency.entities.Country.domain.entity.Country;
import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountryCreateService {
    private final CountryRepository countryRepository;

    public CountryCreateService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void createCountry(Country country) {
        countryRepository.save(country);
    }

}
