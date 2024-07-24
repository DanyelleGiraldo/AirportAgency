package com.airportagency.entities.Plane.application;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class PlaneCreateManufactureService {
    private final ManufacturesRepository manufacturesRepository;

    public PlaneCreateManufactureService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public void createManufacturer(Manufactures manufacture){
        manufacturesRepository.save(manufacture);
    }
}
