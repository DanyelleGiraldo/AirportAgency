package com.airportagency.entities.Manufactures.application;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureCreateService {
    private final ManufacturesRepository manufacturesRepository;

    public ManufactureCreateService(ManufacturesRepository manufacturesRepository){
        this.manufacturesRepository = manufacturesRepository;
    }

    public void createManufacturer(Manufactures manufacture){
        manufacturesRepository.save(manufacture);
    }
}
