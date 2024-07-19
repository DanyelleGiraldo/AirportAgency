package com.airportagency.entities.FlightConnection.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.FlightConnection.application.FlightConnectionCreateService;
import com.airportagency.entities.FlightConnection.application.FlightConnectionDeleteService;
import com.airportagency.entities.FlightConnection.application.FlightConnectionGetAllService;
import com.airportagency.entities.FlightConnection.application.FlightConnectionSearchService;
import com.airportagency.entities.FlightConnection.application.FlightConnectionSearchTripService;
import com.airportagency.entities.FlightConnection.application.FlightConnectionUpdateService;
import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;



public class FlightConnectionConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final FlightConnectionCreateService flightConnectionCreateService;
    private final FlightConnectionDeleteService flightConnectionDeleteService;
    private final FlightConnectionUpdateService flightConnectionUpdateService;
    private final FlightConnectionGetAllService flightConnectionGetAllService;
    private final FlightConnectionSearchService flightConnectionSearchService;
    private final FlightConnectionSearchTripService flightConnectionSearchTripService;

    public FlightConnectionConsoleAdapter(FlightConnectionCreateService flightConnectionCreateService,
            FlightConnectionDeleteService flightConnectionDeleteService,
            FlightConnectionUpdateService flightConnectionUpdateService,
            FlightConnectionGetAllService flightConnectionGetAllService,
            FlightConnectionSearchService flightConnectionSearchService,
            FlightConnectionSearchTripService flightConnectionSearchTripService) {
        this.flightConnectionCreateService = flightConnectionCreateService;
        this.flightConnectionDeleteService = flightConnectionDeleteService;
        this.flightConnectionUpdateService = flightConnectionUpdateService;
        this.flightConnectionGetAllService = flightConnectionGetAllService;
        this.flightConnectionSearchService = flightConnectionSearchService;
        this.flightConnectionSearchTripService = flightConnectionSearchTripService;
    }

    public void createFlightConnection() {
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("REGISTRAR TRAYECTO ");
            System.out.println("INGRESE EL ID DEL TRAYECTO A CREAR: ");
            String id = sc.nextLine();
            Optional<FlightConnection> flightConnection = flightConnectionSearchService.getFlightConnectionById(id);
            flightConnection.ifPresentOrElse(
                f -> {
                    System.out.println(MessageFormat.format(" EL ID (0) YA ESTA OCUPADO.", f.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR TRAYECTO");

                    System.out.println("INGRESE EL ORDEN DEL TRAMO: ");
                    int flightConnectionOrder = sc.nextInt();
    
                    System.out.println("INGRESE EL ID DEL VIAJE: ");
                    String flightConnectionTrip = sc.nextLine();
    
                    System.out.println("INGRESE ID DEL AVION DEL TRAYECTO: ");
                    String flightConnectionPlane = sc.nextLine();
    
                    System.out.println("INGRESE EL AEREOPUERTO DE SALIDA DEL TRAYECTO: ");
                    String flightConnectionAirplaneA = sc.nextLine();

                    System.out.println("INGRESE EL AEREOPUERTO DE LLEGADA DEL TRAYECTO: ");
                    String flightConnectionAirplaneB = sc.nextLine();
    
                    FlightConnection newFlightConnection = new FlightConnection(id, flightConnectionOrder, flightConnectionTrip, flightConnectionPlane, flightConnectionAirplaneA, flightConnectionAirplaneB);
                    flightConnectionCreateService.createFlightConnection(newFlightConnection);
                });

            System.out.println("DESEA AÑADIR OTRO TRAYECTO? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchFlightConnection() {
        List<FlightConnection> flightConnections = flightConnectionGetAllService.getAllFlightConnections();
        
        if (flightConnections.isEmpty()) {
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR TRAMO");
            System.out.println("INGRESE EL ID DEL TRAMO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<FlightConnection> FlightConnection = flightConnectionSearchService.getFlightConnectionById(findId);
            FlightConnection.ifPresentOrElse(
                e -> {
                    System.out.println("TRAMO");
                    System.out.println(MessageFormat.format(" ID : {0}\n ORDEN : {1}\n VIAJE : {2}\n AVION : {3}\nAEREOPUERTO SALIDA : {4}\n AEREOPUERTO LLEGADA : {5}",e.getId(), e.getConnectionOrder(), e.getIdTrip(), e.getIdPlane(), e.getIdAirportA(), e.getIdArportB()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("[!] TRAMO NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("[*] PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void updateFlightConnection() {
        List<FlightConnection> flightConnections = flightConnectionGetAllService.getAllFlightConnections();

        if (flightConnections.isEmpty()) {
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("[?] INGRESE EL ID DEL TRAMO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<FlightConnection> FlightConnection = flightConnectionSearchService.getFlightConnectionById(findId);
            FlightConnection.ifPresentOrElse(
            c -> {
                System.out.println("REGISTRAR TRAYECTO");

                System.out.println("INGRESE EL ORDEN DEL TRAMO: ");
                int flightConnectionOrder = sc.nextInt();

                System.out.println("INGRESE EL ID DEL VIAJE: ");
                String flightConnectionTrip = sc.nextLine();

                System.out.println("INGRESE ID DEL AVION DEL TRAYECTO: ");
                String flightConnectionPlane = sc.nextLine();

                System.out.println("INGRESE EL AEREOPUERTO DE SALIDA DEL TRAYECTO: ");
                String flightConnectionAirplaneA = sc.nextLine();

                System.out.println("INGRESE EL AEREOPUERTO DE LLEGADA DEL TRAYECTO: ");
                String flightConnectionAirplaneB = sc.nextLine();

                FlightConnection newFlightConnection = new FlightConnection(findId, flightConnectionOrder, flightConnectionTrip, flightConnectionPlane, flightConnectionAirplaneA, flightConnectionAirplaneB);
                flightConnectionUpdateService.updateFlightConnection(newFlightConnection);

                System.out.println("TRAMO ACTUALIZADO CORRECTAMENTE.");
                sc.nextLine();
            },
            () -> {
                System.out.println("TRAMO NO ENCONTRADO");
                sc.nextLine();
            }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void deleteFlightConnection() {
        List<FlightConnection> flightConnections = flightConnectionGetAllService.getAllFlightConnections();
        
        if (flightConnections.isEmpty()) {
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL TRAMO A ELIMINAR: ");
            String findId = sc.nextLine();

            flightConnectionDeleteService.deleteFlightConnection(findId);

            Optional<FlightConnection> flightConnection = flightConnectionSearchService.getFlightConnectionById(findId);
            flightConnection.ifPresentOrElse(
                c -> {
                    flightConnectionDeleteService.deleteFlightConnection(findId);
                    System.out.println("TRAMO ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("TRAMO NO ENCONTRADO");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllFlightConnections() {
        List<FlightConnection> flightConnections = flightConnectionGetAllService.getAllFlightConnections();
        
        if (flightConnections.isEmpty()) {
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
            sc.nextLine();
        } else {
            flightConnectionGetAllService.getAllFlightConnections().forEach(f -> {
               System.out.println(MessageFormat.format(" ID : {0}\n ORDEN : {1}\n VIAJE : {2}\n AVION : {3}\n AEREOPUERTO SALIDA : {4}\n AEREOPUERTO LLEGADA : {5}",f.getId(), f.getConnectionOrder(), f.getIdTrip(), f.getIdPlane(), f.getIdAirportA(), f.getIdArportB()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getFlightConnectionByTrip(){

        List<FlightConnection> flightConnections = flightConnectionGetAllService.getAllFlightConnections();
        if (flightConnections.isEmpty()){
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
        }   else{
            System.out.println("CONSULTAR INFORMACION DE TRAYECTO");
            System.out.println("\nINGRESE EL ID DEL VUELO QUE DESEA CONOCER EL TRAYECTO");
            String findIdTrip = sc.nextLine();

            Optional<FlightConnection> connection = flightConnectionSearchTripService.getFlightConnectionByTrip(findIdTrip);
                
            connection.ifPresentOrElse( 
                f -> {
                    System.out.println(MessageFormat.format(" ID : {0}\n ORDEN : {1}\n VIAJE : {2}\n AVION : {3}\n AEREOPUERTO SALIDA : {4}\n AEREOPUERTO LLEGADA : {5}",f.getId(), f.getConnectionOrder(), f.getIdTrip(), f.getIdPlane(), f.getIdAirportA(), f.getIdArportB()));
                },
                () -> {
                    System.out.println("\n NO SE ENCONTRO NINGUNA CONEXION RELACIONADA CON ESTE VUELO\n");
                } 
            );
        }   
    }
}
