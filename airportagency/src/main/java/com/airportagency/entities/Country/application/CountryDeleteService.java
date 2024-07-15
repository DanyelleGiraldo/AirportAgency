package com.airportagency.entities.Country.application;

import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountryDeleteService {
    private final CountryRepository countryRepository;

    public CountryDeleteService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    public void deleteCountry(String id){
        countryRepository.delete(id);
    }
}
