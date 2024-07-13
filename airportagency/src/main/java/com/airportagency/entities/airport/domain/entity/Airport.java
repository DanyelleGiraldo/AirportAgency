package com.airportagency.entities.airport.domain.entity;

public class Airport {
    private String id;
    private String airport;
    private String idCity;

    public Airport(String id, String airport, String idCity) {
        this.id = id;
        this.airport = airport;
        this.idCity = idCity;
    }

    public Airport() {
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.length() != 4) {
            throw new IllegalArgumentException("El ID debe tener exactamente 4 caracteres.");
        }
        this.id = id;
    }
}
