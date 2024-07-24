package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.BookingStatus.infrastructure.out.BookingStatusrepositorySQL;
import com.airportagency.entities.Customer.infrastucture.out.CustomerRepositorySQL;
import com.airportagency.entities.FlightConnection.application.FlightConnectionService;
import com.airportagency.entities.FlightConnection.infrastructure.in.FlightConnectionConsoleAdapter;
import com.airportagency.entities.FlightConnection.infrastructure.out.FlightConnectionMySQLRepository;
import com.airportagency.entities.FlightFares.application.FlightFareService;
import com.airportagency.entities.FlightFares.infrastructure.in.FlightFareConsoleAdapter;
import com.airportagency.entities.FlightFares.infrastructure.out.FlightFareSQLRepository;
import com.airportagency.entities.Manufactures.infrastructure.out.ManufactureSQLRepository;
import com.airportagency.entities.Plane.application.PlanesService;
import com.airportagency.entities.Plane.infrastructure.in.PlaneConsoleAdapter;
import com.airportagency.entities.Plane.infrastructure.out.PlaneSQLRepository;
import com.airportagency.entities.PlaneModel.infrastructure.out.PlaneModelSQLRepository;
import com.airportagency.entities.Status.infrastructure.out.StatusSQLRepository;
import com.airportagency.entities.Trip.application.TripService;
import com.airportagency.entities.Trip.infrastructure.in.TripConsoleAdapter;
import com.airportagency.entities.Trip.infrastructure.out.TripSQLRepository;
import com.airportagency.entities.TripBooking.infrastructure.out.TripBookingSQLRepository;
import com.airportagency.entities.airport.infrastucture.out.AirportRepositorySQL;
public class AdminView {
    PlaneSQLRepository planesMySQLRepository = new PlaneSQLRepository();
    PlaneModelSQLRepository planeModelSQLRepository = new PlaneModelSQLRepository();
    StatusSQLRepository statusSQLRepository = new StatusSQLRepository();
    ManufactureSQLRepository manufactureSQLRepository = new ManufactureSQLRepository();
    TripSQLRepository tripSQLRepository = new TripSQLRepository();
    BookingStatusrepositorySQL bookingStatusrepositorySQL = new BookingStatusrepositorySQL();
    TripBookingSQLRepository   tripBookingSQLRepository = new TripBookingSQLRepository();
    AirportRepositorySQL airportRepositorySQL = new AirportRepositorySQL();
    CustomerRepositorySQL customerRepositorySQL = new CustomerRepositorySQL();
    FlightConnectionMySQLRepository FlightConnectionMySQLRepository = new FlightConnectionMySQLRepository();
    FlightFareSQLRepository flightFareSQLRepository = new FlightFareSQLRepository();
    



    public void start(){
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("1. Gestion de Aviones");
                System.out.println("2. Gestion de Vuelos");
                System.out.println("3. Gestion de Aeropuertos");
                System.out.println("4. Gestion de Documentos ");
                System.out.println("5. Conexiones de Vuelos");
                System.out.println("6. Tarifas de Vuelo");
                System.out.println("7. Salir");
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        System.out.println("1. Register plane");
                        System.out.println("2. View plane information");
                        System.out.println("3. Update plane information");
                        System.out.println("4. Delete plane");
                        System.out.println("5. Salir");

                        int op= scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planesConsoleController = new PlaneConsoleAdapter(planesService);
                                planesConsoleController.createPlanes();
                            }
                            case 2 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.searchPlane();
                            }
                            case 3 ->{
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.updatePlane();
                            }
                            case 4 ->{
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.deletePlane();
                            }
                            case 5 ->{
                                start();
                            }
                        }           
                    }
                    case 2 ->{
                        System.out.println("1.Asignar tripulación de vuelo");
                        System.out.println("2.Ver información del vuelo");
                        System.out.println("3.Actualizar información del vuelo");
                        System.out.println("4.Eliminar vuelo");
                        System.out.println("5.Ver asignación de tripulación");
                        System.out.println("6.Ver conexiones de vuelo");
                        System.out.println("7.Actualizar información de conexión de vuelo");
                        System.out.println("8.Eliminar conexión de vuelo");
                        System.out.println("9.Registrar tarifa de vuelo");
                        System.out.println("10.Actualizar información de tarifa de vuelo");
                        System.out.println("11.Eliminar tarifa de vuelo");
                        System.out.println("12.Ver tarifa de vuelo");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 ->{

                            }
                            case 2 ->{
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.searchTrip();
                            }
                            case 3 ->{
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter =  new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.updateTrip();
                            }
                            case 4 ->{
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.deleteTrip();
                            }
                            case 5 ->{

                            }
                            case 6 ->{
                                FlightConnectionService flightConnectionService = new FlightConnectionService(FlightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.getAllFlightConnections();
                            }
                            case 7->{
                                FlightConnectionService flightConnectionService = new FlightConnectionService(FlightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.updateFlightConnection();
                            }
                            case 8->{
                                FlightConnectionService flightConnectionService = new FlightConnectionService(FlightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.deleteFlightConnection();
                            }
                            case 9->{
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightConnectionConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightConnectionConsoleAdapter.createFlightFare();
                            }
                            case 10->{
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightConnectionConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightConnectionConsoleAdapter.updateFlightFare();
                            }

                        }
                    }
                    case 3->{
                        
                    }
                    
                    case 7 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                        }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 7.");
                }
            }
        }
    }
}
