package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.BookingStatus.infrastructure.out.BookingStatusrepositorySQL;
import com.airportagency.entities.Customer.application.CustomerService;
import com.airportagency.entities.Customer.infrastucture.in.CustomerConsoleAdapter;
import com.airportagency.entities.Customer.infrastucture.out.CustomerRepositorySQL;
import com.airportagency.entities.FlightConnection.application.FlightConnectionService;
import com.airportagency.entities.FlightConnection.infrastructure.in.FlightConnectionConsoleAdapter;
import com.airportagency.entities.FlightConnection.infrastructure.out.FlightConnectionMySQLRepository;
import com.airportagency.entities.FlightFares.infrastructure.out.FlightFareSQLRepository;
import com.airportagency.entities.Plane.infrastructure.out.PlaneSQLRepository;
import com.airportagency.entities.Trip.application.TripService;
import com.airportagency.entities.Trip.infrastructure.in.TripConsoleAdapter;
import com.airportagency.entities.Trip.infrastructure.out.TripSQLRepository;
import com.airportagency.entities.TripBooking.application.TripBookingService;
import com.airportagency.entities.TripBooking.infrastructure.in.TripBookingConsoleAdapter;
import com.airportagency.entities.TripBooking.infrastructure.out.TripBookingSQLRepository;
import com.airportagency.entities.airport.infrastucture.out.AirportRepositorySQL;
import com.airportagency.entities.tripbookindetails.infrastructure.out.TripBookingDetailsSQLRepository;

public class SellsView {
    CustomerRepositorySQL customerRepositorySQL = new CustomerRepositorySQL();
    TripSQLRepository tripSQLRepository = new TripSQLRepository();
    TripBookingSQLRepository tripBookingSQLRepository = new TripBookingSQLRepository();
    BookingStatusrepositorySQL bookingStatusrepositorySQL  = new BookingStatusrepositorySQL();
    FlightFareSQLRepository flightFareSQLRepository = new FlightFareSQLRepository();
    TripBookingDetailsSQLRepository tripBookingDetailsSQLRepository = new TripBookingDetailsSQLRepository();
    FlightConnectionMySQLRepository flightConnectionMySQLRepository = new FlightConnectionMySQLRepository();
    PlaneSQLRepository planeSQLRepository = new PlaneSQLRepository();
    AirportRepositorySQL airportRepositorySQL = new AirportRepositorySQL();

    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Create booking");
                System.out.println("2. View customer information");
                System.out.println("3. View flights bookings");
                System.out.println("4. Create customer");
                System.out.println("5. Update customer info");
                System.out.println("6. Delete flight booking");
                System.out.println("7. View flight information");
                System.out.println("8. View flight connections");
                System.out.println("9. View flight fare");
                System.out.println("10. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.createTripBooking();
                    }
                    case 2 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
                        customerConsoleAdapter.searchCustomer();
                    }
                    case 3 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.searchTripBooking();
                    }
                    case 4 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
                        customerConsoleAdapter.createCustomer();
                    }
                    case 5 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
                        customerConsoleAdapter.updateCustomer();
                    }
                    case 6 -> {
                        CustomerService customerService =  new CustomerService(customerRepositorySQL);
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.deleteTripBooking();
                    }
                    case 7 -> {
                        TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                        TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                        tripConsoleAdapter.searchTrip();
                    }
                    case 8 -> {
                        System.out.println("...");
                    }
                    case 9 -> {
                        FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionMySQLRepository);
                        FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);
                        flightConnectionConsoleAdapter.getFlightConnectionByTrip();
                    }
                    case 10 -> salir = true;
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 10.");
                }
            }
        }
    }
}
