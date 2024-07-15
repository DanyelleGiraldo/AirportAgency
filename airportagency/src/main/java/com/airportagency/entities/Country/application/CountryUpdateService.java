package com.airportagency.entities.Country.application;

import com.airportagency.entities.Country.domain.entity.Country;
import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountryUpdateService {
    private final CountryRepository countryRepository;

    public CountryUpdateService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void updateCountry(Country country){
        countryRepository.update(country);
    }
}
