package com.airportagency.entities.airline.infrastucture.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.airline.application.AirlineUpdateService;
import com.airportagency.entities.airline.application.AirlineCreateService;
import com.airportagency.entities.airline.application.AirlineDeleteService;
import com.airportagency.entities.airline.application.AirlineGetAllService;
import com.airportagency.entities.airline.application.AirlineSearchService;
import com.airportagency.entities.airline.domain.entity.Airline;

public class AirlinesConsoleAdapter {
    private final Scanner scanner = new Scanner(System.in);
    private final AirlineCreateService airlineCreateService;
    private final AirlineUpdateService airlineUpdateService;
    private final AirlineSearchService airlineSearchService;
    private final AirlineDeleteService airlineDeleteService;
    private final AirlineGetAllService airlineGetAllService;

    public AirlinesConsoleAdapter(AirlineCreateService airlineCreateService, AirlineUpdateService airlineUpdateService,
            AirlineSearchService airlineSearchService, AirlineDeleteService airlineDeleteService,
            AirlineGetAllService airlineGetAllService) {
        this.airlineCreateService = airlineCreateService;
        this.airlineUpdateService = airlineUpdateService;
        this.airlineSearchService = airlineSearchService;
        this.airlineDeleteService = airlineDeleteService;
        this.airlineGetAllService = airlineGetAllService;
    }

    public void createAirline() {
        String option = "S";
        while (option.equalsIgnoreCase("S")) {
            System.out.println("INGRESE EL ID DE LA AEROLINEA");
            String newId = scanner.nextLine();
            Optional<Airline> airline = airlineSearchService.getAirlineById(newId);
            airline.ifPresentOrElse(
                a -> {
                    System.out.println("AEROLINEA YA EXISTENTE");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    scanner.nextLine();
                },
                () -> {
                    System.out.println("INGRESE EL NOMBRE DE LA AEROLINEA A CREAR");
                    String nameAirline = scanner.nextLine();
                    Airline newAirline = new Airline(newId, nameAirline);
                    airlineCreateService.createAirline(newAirline);
                }
            );
            System.out.println("DESEA CREAR OTRA AEROLINEA? [S] SI | [CUALQUIER TECLA] NO");
            option = scanner.nextLine();
        }
    }

    public void searchAirline() {
        System.out.println("INGRESE EL ID DE LA AEROLINEA A BUSCAR");
        String airlineId = scanner.nextLine();
        Optional<Airline> airline = airlineSearchService.getAirlineById(airlineId);
        airline.ifPresentOrElse(
            a -> System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getName()),
            () -> System.out.println("AEROLINEA NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void updateAirline() {
        System.out.println("INGRESE EL ID DE LA AEROLINEA A EDITAR");
        String airlineId = scanner.nextLine();
        Optional<Airline> airline = airlineSearchService.getAirlineById(airlineId);
        airline.ifPresentOrElse(
            a -> {
                System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getName());
                System.out.println("INGRESE EL NUEVO NOMBRE DE LA AEROLINEA");
                String newName = scanner.nextLine();
                Airline updatedAirline = new Airline(a.getId(), newName);
                airlineUpdateService.updateAirline(updatedAirline);
            },
            () -> System.out.println("AEROLINEA NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void deleteAirline() {
        System.out.println("INGRESE EL ID DE LA AEROLINEA A ELIMINAR");
        String airlineId = scanner.nextLine();
        Optional<Airline> airline = airlineSearchService.getAirlineById(airlineId);
        airline.ifPresentOrElse(
            a -> {
                airlineDeleteService.deleteAirline(airlineId);
                System.out.println("AEROLINEA ELIMINADA");
            },
            () -> System.out.println("AEROLINEA NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void getAllAirlines() {
        List<Airline> allAirlines = airlineGetAllService.getAllAirlines();
        if (allAirlines.isEmpty()) {
            System.out.println("NO HAY AEROLINEAS REGISTRADAS");
        } else {
            System.out.println("AEROLINEAS REGISTRADAS");
            allAirlines.forEach(a -> System.out.println("ID: " + a.getId() + " NOMBRE: " + a.getName()));
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }
}
