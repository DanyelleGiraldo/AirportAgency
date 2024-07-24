package com.airportagency.entities.Plane.application;

import java.util.Optional;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class PlaneSearchManufactureService {
    private final ManufacturesRepository manufacturesRepository;

    public PlaneSearchManufactureService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public Optional<Manufactures> getManufacturerById(String id){
        return manufacturesRepository.findById(id);
    }
}
