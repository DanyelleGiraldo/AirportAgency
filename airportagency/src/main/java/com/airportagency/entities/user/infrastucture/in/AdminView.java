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
import com.airportagency.entities.airport.application.AirportService;
import com.airportagency.entities.airport.infrastucture.in.AirportConsoleAdapter;
import com.airportagency.entities.airport.infrastucture.out.AirportRepositorySQL;

public class AdminView {
    PlaneSQLRepository planesMySQLRepository = new PlaneSQLRepository();
    PlaneModelSQLRepository planeModelSQLRepository = new PlaneModelSQLRepository();
    StatusSQLRepository statusSQLRepository = new StatusSQLRepository();
    ManufactureSQLRepository manufactureSQLRepository = new ManufactureSQLRepository();
    TripSQLRepository tripSQLRepository = new TripSQLRepository();
    BookingStatusrepositorySQL bookingStatusrepositorySQL = new BookingStatusrepositorySQL();
    TripBookingSQLRepository tripBookingSQLRepository = new TripBookingSQLRepository();
    AirportRepositorySQL airportRepositorySQL = new AirportRepositorySQL();
    CustomerRepositorySQL customerRepositorySQL = new CustomerRepositorySQL();
    FlightConnectionMySQLRepository flightConnectionMySQLRepository = new FlightConnectionMySQLRepository();
    FlightFareSQLRepository flightFareSQLRepository = new FlightFareSQLRepository();

    public void start(){
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("1.Gestion de Aviones");
                System.out.println("2.Gestion de Vuelos");
                System.out.println("3.Gestion de Aeropuertos");
                System.out.println("4.Gestión de Conexiones de Vuelo");
                System.out.println("5.Gestión de Tarifas de Vuelo");
                System.out.println("6.Salir");
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        System.out.println("1.Registrar avión");
                        System.out.println("2.Ver información del avión");
                        System.out.println("3.Actualizar información del avión");
                        System.out.println("4.Eliminar avión");
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
                            case 3 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.updatePlane();
                            }
                            case 4 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.deletePlane();
                            }
                            case 5 -> start();
                        }           
                    }
                    case 2 -> {
                        System.out.println("1.Ver informacion de un vuelo");
                        System.out.println("2.Actualizar informacion de un vuelo");
                        System.out.println("3.Eliminar vuelo");
                        System.out.println("4.Salir");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.searchTrip();
                            }
                            case 2 -> {
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.updateTrip();
                            }
                            case 3 -> {
                                TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                                tripConsoleAdapter.deleteTrip();
                            }
                            case 4 -> {
                                start();
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("1.Crear aeropuerto");
                        System.out.println("2.Ver información del aeropuerto");
                        System.out.println("3.Actualizar información del aeropuerto");
                        System.out.println("4.Eliminar aeropuerto");
                        System.out.println("5.Salir");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                AirportService airportService = new AirportService(airportRepositorySQL);
                                AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
                                airportConsoleAdapter.createAirport();
                            }
                            case 2 -> {
                                AirportService airportService = new AirportService(airportRepositorySQL);
                                AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
                                airportConsoleAdapter.searchAirport();
                            }
                            case 3 -> {
                                AirportService airportService = new AirportService(airportRepositorySQL);
                                AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
                                airportConsoleAdapter.updateAirport();
                            }
                            case 4 -> {
                                AirportService airportService = new AirportService(airportRepositorySQL);
                                AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
                                airportConsoleAdapter.deleteAirport();
                            }
                            case 5 -> start();
                        }
                    }
                    case 4->{
                        System.out.println("1.Ver conexiones de vuelo");
                        System.out.println("2.Actualizar informacion de conexion de vuelo");
                        System.out.println("3.Eliminar conexión de vuelo");
                        System.out.println("4.Salir");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.searchFlightConnection();
                            }
                            case 2 -> {
                                FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.updateFlightConnection();
                            }
                            case 3 -> {
                                FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionMySQLRepository);
                                FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                                flightConnectionConsoleAdapter.deleteFlightConnection();
                            }
                            case 4 -> start();
                        }
                    }
                    case 5->{
                        System.out.println("1.Registrar tarifa de vuelo");
                        System.out.println("2.Actualizar información de tarifa de vuelo");
                        System.out.println("3.Eliminar tarifa de vuelo");
                        System.out.println("4.Ver tarifa de vuelo");
                        System.out.println("5.Salir");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightFareConsoleAdapter.createFlightFare();
                            }
                            case 2 -> {
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightFareConsoleAdapter.updateFlightFare();
                            }
                            case 3 -> {
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightFareConsoleAdapter.deleteFlightFare();
                            }
                            case 4 -> {
                                FlightFareService flightFareService = new FlightFareService(flightFareSQLRepository);
                                FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);
                                flightFareConsoleAdapter.searchFlightFare();
                            }
                            case 5-> start();
                        }


                    }
                    case 6 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                    }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 6.");
                }
            }
        }
    }
}
