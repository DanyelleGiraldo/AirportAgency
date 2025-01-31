package com.airportagency.entities.PlaneModel.domain.entity;

public class PlaneModels {
    private String id;
    private String model;
    private String idManufacturer;

    public PlaneModels(){}

    public PlaneModels(String id, String model, String idManufacturer) {
        this.id = id;
        this.model = model;
        this.idManufacturer = idManufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    
}
