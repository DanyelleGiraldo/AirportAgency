package com.airportagency.entities.Manufactures.application;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureUpdateService {
    private final ManufacturesRepository manufacturesRepository;

    public ManufactureUpdateService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public void updateManufacturer(Manufactures manufacture){
        manufacturesRepository.update(manufacture);
    }
}
