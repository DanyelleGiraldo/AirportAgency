package com.airportagency.entities.Manufactures.application;

import java.util.Optional;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureSearchService {
    private final ManufacturesRepository manufacturesRepository;

    public ManufactureSearchService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public Optional<Manufactures> getManufacturerById(String id){
        return manufacturesRepository.findById(id);
    }
}
