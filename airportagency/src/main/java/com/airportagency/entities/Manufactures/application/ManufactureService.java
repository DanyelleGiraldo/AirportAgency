package com.airportagency.entities.Manufactures.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Manufactures.domain.service.ManufacturesRepository;

public class ManufactureService {
     private final ManufacturesRepository manufacturesRepository;

    public ManufactureService(ManufacturesRepository manufacturesRepository){
        this.manufacturesRepository = manufacturesRepository;
    }

    public void createManufacturer(Manufactures manufacture){
        manufacturesRepository.save(manufacture);
    }

    public void updateManufacturer(Manufactures manufacture){
        manufacturesRepository.update(manufacture);
    }

    public Optional<Manufactures> getManufacturerById(String id){
        return manufacturesRepository.findById(id);
    }

    public void deleteManufacturer(String id){
        manufacturesRepository.delete(id);
    }

    public List<Manufactures> getAllManufactures(){
        return manufacturesRepository.findAll();
    }
}
