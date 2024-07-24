package com.airportagency.entities.Plane.application;

import java.util.List;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class PlaneGetAllManufactureService {
    private final ManufacturesRepository manufacturesRepository;

    public PlaneGetAllManufactureService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }


    public List<Manufactures> getAllManufactures(){
        return manufacturesRepository.findAll();
    }
}
