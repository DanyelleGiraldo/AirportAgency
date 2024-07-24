package com.airportagency.entities.Trip.infrastructure.in;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Trip.application.TripService;
import com.airportagency.entities.Trip.domain.entity.Trip;

public class TripConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final TripService tripService;



    public TripConsoleAdapter(TripService tripService) {
        this.tripService = tripService;
    }


    public void createTrip(){
        String rta = "S";

        while (rta.equalsIgnoreCase("S")){
            System.out.println("*************** REGISTRAR VIAJE ***************");
            System.out.println("INGRESE EL ID DEL VIAJE A CREAR: ");
            String id = sc.nextLine();
            Optional<Trip> trip = tripService.getTripById(id);
            trip.ifPresentOrElse(
                t -> {
                    System.out.println(MessageFormat.format("[!] EL VIAJE CON ID (0) YA EXISTE.", t.getId()));
                },
                () -> {
                    System.out.println("*************** REGISTRAR VIAJE ***************");

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaReserva = null;
                    boolean isActiveDate = false;
                    String newDate = "";

                    while (!isActiveDate) {
                        System.out.println("\nINGRESE LA FECHA DE VIAJE (dd-MM-yyyy)");
                        System.out.print("INGRESE LA FECHA DE LA VIAJE: ");
                        newDate = sc.nextLine();

                        try {
                            fechaReserva = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }

                    System.out.println("\nINGRESE EL PRECIO DE VIAJE: ");
                    Double tripPrice = sc.nextDouble();

                    Trip newTrip = new Trip(id, fechaReserva, tripPrice);
                    tripService.createTrip(newTrip);
                    sc.nextLine();
                });
            System.out.println("DESEA AÑADIR OTRO VIAJE? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }


    public void searchTrip() {
        List<Trip> trips = tripService.getAllTrips();
    
        if (trips.isEmpty()) {
            System.out.println("NO HAY NINGUN VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("*************** BUSCAR VIAJE ***************");
            System.out.println("INGRESE EL ID DEL VIAJE A BUSCAR: ");
            String findId = sc.nextLine();
    
            Optional<Trip> trip = tripService.getTripById(findId);
            trip.ifPresentOrElse(
                t -> {
                    System.out.println("*************** VIAJE ***************");
                    System.out.println(MessageFormat.format("ID : {0}\nFECHA DE VIAJE : {1}\nPRECIO DE VIAJE: {2}\n", t.getId(), t.getTripDate(), t.getPrice()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("VIAJE NO ENCONTRADO");
                    sc.nextLine();
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }


    public void updateTrip(){
        List<Trip> trips = tripService.getAllTrips();

        if(trips.isEmpty()){

            System.out.println("NO HAY VIAJE REGISTRADAS");

        }  else {

            System.out.println("INGRESE EL ID DEL VIAJE A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<Trip> trip = tripService.getTripById(findId);
            trip.ifPresentOrElse(
            t -> {
                System.out.println("ID: "+ t.getId() + "\nFECHA DE VIAJE: " + t.getTripDate() + "\n PRECIO DE VIAJE: " + t.getPrice());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaViaje = null;
                    boolean isActiveDate = false;
                    String newDate = "";

                    while (!isActiveDate) {
                        System.out.println("\nINGRESE LA FECHA DE VIAJE (dd-MM-yyyy)");
                        System.out.print("INGRESE LA FECHA DE VIAJE: ");
                        newDate = sc.nextLine();

                        try {
                            fechaViaje = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }
                    System.out.println("\nINGRESE EL PRECIO DEL VIAJE: ");
                    Double updPrice = sc.nextDouble();

                      
                    Trip tripsBooking = new Trip(findId, fechaViaje, updPrice);
                    tripService.updateTrip(tripsBooking);
            },
            () -> System.out.println("VIAJE NO ENCONTRADO")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
        }
    }


    public void deleteTrip(){
        List<Trip> trips = tripService.getAllTrips();
        if(trips.isEmpty()){
            System.out.println("NO HAY NINGUN VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL VIAJE A ELIMINAR\n\n");
            String findId = sc.nextLine();


            Optional<Trip> trip = tripService.getTripById(findId);
            trip.ifPresentOrElse(
                c -> {
                    tripService.deleteTrip(findId);
                    System.out.println("VIAJE ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("VIAJE NO ENCONTRADO");

                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
        if (trips.isEmpty()) {
            System.out.println("NO HAY NINGUN VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            trips.forEach(t -> {
                String formattedDate = t.getTripDate().format(formatter);
                System.out.println(MessageFormat.format("ID : {0}\nFECHA DE VIAJE : {1}\nPRECIO DE VIAJE: {2}\n", t.getId(), formattedDate, t.getPrice()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getTripsByParameters() {
        List<Trip> trips = tripService.getAllTrips();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
        if (trips.isEmpty()) {
            System.out.println("NO HAY NINGUN VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            @SuppressWarnings("unused")
            LocalDate tripDate = null;
            boolean isActiveDate = true;
            String newDate = "";

            while (isActiveDate) {
                System.out.println("\nINGRESE LA FECHA DEL VIAJE (dd-mm-yyyy)");
                newDate = sc.nextLine();

                try {
                    tripDate = LocalDate.parse(newDate, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("FECHA INVALIDA. FORMATO: (dd-mm-yyyy).");
                    sc.nextLine();
                }
            }           

        }
    }
}
