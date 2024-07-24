package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.BookingStatus.infrastructure.out.BookingStatusrepositorySQL;
import com.airportagency.entities.Customer.application.CustomerService;
import com.airportagency.entities.Customer.infrastucture.out.CustomerRepositorySQL;
import com.airportagency.entities.FlightConnection.infrastructure.out.FlightConnectionMySQLRepository;
import com.airportagency.entities.FlightFares.infrastructure.out.FlightFareSQLRepository;
import com.airportagency.entities.Payment.application.PaymentService;

import com.airportagency.entities.Payment.infrastructure.in.PaymentConsoleAdapter;
import com.airportagency.entities.Payment.infrastructure.out.PaymentSQLRepository;
import com.airportagency.entities.PaymentMethod.infrastructure.out.PaymentMethodSQLRepository;
import com.airportagency.entities.Plane.infrastructure.out.PlaneSQLRepository;
import com.airportagency.entities.Trip.application.TripService;
import com.airportagency.entities.Trip.infrastructure.in.TripConsoleAdapter;
import com.airportagency.entities.Trip.infrastructure.out.TripSQLRepository;
import com.airportagency.entities.TripBooking.application.TripBookingService;
import com.airportagency.entities.TripBooking.infrastructure.in.TripBookingConsoleAdapter;
import com.airportagency.entities.TripBooking.infrastructure.out.TripBookingSQLRepository;
import com.airportagency.entities.airport.infrastucture.out.AirportRepositorySQL;
import com.airportagency.entities.tripbookindetails.infrastructure.out.TripBookingDetailsSQLRepository;

public class CustomerView {
    TripSQLRepository tripSQLRepository = new TripSQLRepository();
    BookingStatusrepositorySQL bookingStatusrepositorySQL = new BookingStatusrepositorySQL();
    TripBookingSQLRepository tripBookingSQLRepository = new TripBookingSQLRepository();
    AirportRepositorySQL airportRepositorySQL = new AirportRepositorySQL();
    CustomerRepositorySQL customerRepositorySQL = new CustomerRepositorySQL();
    FlightFareSQLRepository flightFareSQLRepository = new FlightFareSQLRepository();
    FlightConnectionMySQLRepository flightConnectionMySQLRepository = new FlightConnectionMySQLRepository();
    TripBookingDetailsSQLRepository tripBookingDetailsSQLRepository = new TripBookingDetailsSQLRepository();
    PlaneSQLRepository planeSQLRepository = new PlaneSQLRepository();
    CustomerService customerService = new CustomerService(customerRepositorySQL);
    PaymentSQLRepository paymentSQLRepository = new PaymentSQLRepository();
    PaymentMethodSQLRepository paymentMethodSQLRepository = new PaymentMethodSQLRepository();

    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("1. Buscar vuelo");
                System.out.println("2. Seleccionar vuelo");
                System.out.println("3. Realizar pago");
                System.out.println("4. Ver reserva de vuelo");
                System.out.println("5. Cancelar reserva de vuelo");
                System.out.println("6. Actualizar reserva de vuelo");
                System.out.println("7. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        TripService tripService = new TripService(tripSQLRepository, bookingStatusrepositorySQL, tripBookingSQLRepository, airportRepositorySQL, customerRepositorySQL);
                        TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
                        tripConsoleAdapter.searchTrip();
                    }
                    case 2 -> {
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.selectTripBooking();
                    }
                    case 3 -> {
                        PaymentService paymentService = new PaymentService(paymentSQLRepository, paymentMethodSQLRepository, tripBookingSQLRepository);
                        PaymentConsoleAdapter paymentConsoleAdapter = new PaymentConsoleAdapter(paymentService);
                        paymentConsoleAdapter.createPayment();
                    }
                    case 4 -> {
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.getAllTripBookings();
                    }
                    case 5 -> {
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.cancelTripBooking();
                    }
                    case 6 -> {
                        TripBookingService tripBookingService = new TripBookingService(tripSQLRepository, customerRepositorySQL, tripBookingSQLRepository, bookingStatusrepositorySQL, flightFareSQLRepository, tripBookingDetailsSQLRepository, flightConnectionMySQLRepository, planeSQLRepository);
                        TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService, customerService);
                        tripBookingConsoleAdapter.updateTripBooking();
                    }
                    case 7 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                    }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 9.");
                }
            }
        }
    }
}
