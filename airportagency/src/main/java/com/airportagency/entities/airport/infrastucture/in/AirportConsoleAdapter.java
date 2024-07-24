package com.airportagency.entities.airport.infrastucture.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.airport.application.AirportService;
import com.airportagency.entities.airport.domain.entity.Airport;

public class AirportConsoleAdapter {
    private final Scanner sc = new Scanner(System.in);
    private final AirportService airportService;

    

    public AirportConsoleAdapter(AirportService airportService) {
        this.airportService = airportService;
    }

    public void createAirport() {
        String option = "S";
        while (option.equalsIgnoreCase("S")) {
            System.out.println("INGRESE EL ID DEL AEROPUERTO (4 caracteres):");
            String newID = sc.nextLine();
            if (newID.length() != 4) {
                System.out.println("El ID debe tener exactamente 4 caracteres.");
                continue;
            }
            Optional<Airport> airport = airportService.getAirportById(newID);
            airport.ifPresentOrElse(a -> {
                System.out.println("EL AEROPUERTO YA EXISTE");
                System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
                sc.nextLine();
            }, () -> {
                System.out.println("INGRESE EL NOMBRE DEL AEROPUERTO");
                String nameAirport = sc.nextLine();
                System.out.println("INGRESE EL ID DE LA CIUDAD DEL AEROPUERTO");
                String idCity = sc.nextLine();
                Airport newAirport = new Airport(newID, nameAirport, idCity);
                airportService.createAirport(newAirport);
            });
            System.out.println("¿DESEA CREAR OTRO AEROPUERTO? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();
        }
    }

    public void searchAirport() {
        System.out.println("INGRESE EL ID DEL AEROPUERTO A BUSCAR:");
        String airportId = sc.nextLine();
        Optional<Airport> airport = airportService.getAirportById(airportId);
        airport.ifPresentOrElse(a -> System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getAirport() + " ID CIUDAD: " + a.getIdCity()),
                () -> System.out.println("AEROPUERTO NO ENCONTRADO"));
        System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
        sc.nextLine();
    }

    public void updateAirport() {
        System.out.println("INGRESE EL ID DEL AEROPUERTO A EDITAR:");
        String airportId = sc.nextLine();
        Optional<Airport> airport = airportService.getAirportById(airportId);
        airport.ifPresentOrElse(a -> {
            System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getAirport() + " ID CIUDAD: " + a.getIdCity());
            System.out.println("INGRESE EL NUEVO NOMBRE DEL AEROPUERTO:");
            String newName = sc.nextLine();
            System.out.println("INGRESE EL ID DE LA NUEVA CIUDAD:");
            String newCity = sc.nextLine();
            Airport updatedAirport = new Airport(a.getId(), newName, newCity);
            airportService.updateAirport(updatedAirport);
        }, () -> System.out.println("AEROPUERTO NO ENCONTRADO"));
        System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
        sc.nextLine();
    }

    public void deleteAirport(){
        System.out.println("INGRESE EL ID DEL AEREOPUERTO A ELIMINAR");
        String airportId = sc.nextLine();
        Optional<Airport> airport = airportService.getAirportById(airportId);
        airport.ifPresentOrElse(a->{
            airportService.deleteAirport(airportId);
            System.out.println("AEREOPUERTO ELIMINADO");
        }, ()-> System.out.println("AEREOPUERTO NO ENCONTRADO"));

        System.out.println("PRESIONE CUALQUIER TECLA PARA SEGUIR");
        sc.nextLine();
    }

    public void getAllAirports (){
        List<Airport> allAirports  = airportService.getAllAirports();
        if(allAirports.isEmpty()){
            System.out.println("NO HAY AEREOPUERTOS REGISTRADOS");
        }else {
            System.out.println("AEREOPUERTOS NO REGISTRADOS");
            allAirports.forEach(a -> 
            System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getAirport() + " ID CIUDAD: " + a.getIdCity()));
        }

        }
    }

