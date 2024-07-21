package com.airportagency.entities.Manufactures.application;

import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureDeleteService {
    private final ManufacturesRepository manufacturesRepository;

    public ManufactureDeleteService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }
    
    public void deleteManufacturer(String id){
        manufacturesRepository.delete(id);
    }
}
