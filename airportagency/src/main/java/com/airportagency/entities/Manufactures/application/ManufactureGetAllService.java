package com.airportagency.entities.Manufactures.application;

import java.util.List;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureGetAllService {
    private final ManufacturesRepository manufacturesRepository;

    public ManufactureGetAllService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public List<Manufactures> getAllManufactures(){
        return manufacturesRepository.findAll();
    }
}
