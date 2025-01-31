package com.airportagency.entities.airline.domain.entity;

public class Airline {
    private String id;
    private String name;

    public Airline(){
        
    }

    public Airline(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Airline(String name){
        this.name = name;
    }

    // GETTERS Y SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
