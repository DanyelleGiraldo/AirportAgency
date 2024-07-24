package com.airportagency.entities.TripBooking.infrastructure.in;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.Customer.application.CustomerService;
import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.infrastucture.in.CustomerConsoleAdapter;
import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.Trip.domain.entity.Trip;
import com.airportagency.entities.TripBooking.application.TripBookingService;
import com.airportagency.entities.TripBooking.domain.entity.TripBooking;

public class TripBookingConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final TripBookingService tripBookingService;

    private final CustomerService customerService;



    public TripBookingConsoleAdapter(TripBookingService tripBookingService, CustomerService customerService) {
        this.tripBookingService = tripBookingService;
        this.customerService = customerService;
    }

    public void createTripBooking() {
        String rta = "S";
    
        while (rta.equalsIgnoreCase("S")) {
            System.out.println("*************** REGISTRAR RESERVA DE VUELO ***************");
            String id = "";
            boolean isValidId = false;
    
            while (!isValidId) {
                System.out.println("ASIGNE UN ID A LA RESERVA DE VUELO A CREAR (MÁXIMO 5 CARACTERES): ");
                id = sc.nextLine();
    
                if (id.length() <= 5) {
                    isValidId = true;
                } else {
                    System.out.println("ID NO VÁLIDO. DEBE SER DE MÁXIMO 5 CARACTERES.");
                }
            }
            final String finalId = id;
            Optional<TripBooking> tripBooking = tripBookingService.getTripBookingById(id);
            tripBooking.ifPresentOrElse(
                t -> {
                    System.out.println(MessageFormat.format("LA RESERVA CON ID ({0}) YA ESTÁ OCUPADA.", t.getId()));
                },
                () -> {
                    System.out.println("*************** REGISTRAR RESERVA DE VUELO ***************");
    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaReserva = null;
                    boolean isActiveDate = false;
    
                    while (!isActiveDate) {
                        System.out.println("\n INGRESE LA FECHA DE RESERVA DE VUELO (dd-MM-yyyy)");
                        System.out.print("INGRESE LA FECHA DE LA RESERVA DE VUELO: ");
                        String newDate = sc.nextLine();
    
                        try {
                            fechaReserva = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }
    

                    System.out.println("\nINGRESE EL ID DEL CLIENTE: ");
                    String newIdCustomer = sc.nextLine();
    
                    Optional<Customer> isValidCustomer = tripBookingService.getCustomerById(newIdCustomer);
    
                    if (isValidCustomer.isEmpty()) {
                        System.out.println("ID DE CLIENTE NO VALIDO. EL CLIENTE NO EXISTE.");
                        return; 
                    }
                    

                    System.out.println("\nINGRESE EL ID DEL VUELO: ");
                    String newIdTrip = sc.nextLine();
    
                    Optional<Trip> isValidTrip= tripBookingService.getTripById(newIdTrip);
    
                    if (isValidTrip.isEmpty()) {
                        System.out.println("ID DE VUELO NO VALIDO. EL VUELO NO EXISTE.");
                        return; 
                    }

                    List<BookingStatus> bookingStatuses = tripBookingService.getAllBookingStatuses();
                    if (bookingStatuses.isEmpty()) {
                        System.out.println("NO SE ENCONTRARON ESTADOS DE RESERVA DISPONIBLES.");
                        return; 
                    }

                    System.out.println("\nESTADOS DE RESERVA DISPONIBLES:");
                    for (BookingStatus status : bookingStatuses) {
                        System.out.println("- ID: " + status.getId() + ", ESTADO: " + status.getBookingStatus());
                    }
    
                    System.out.println("\nINGRESE EL ID DEL ESTADO DE RESERVA: ");
                    int newIdStatus = sc.nextInt();

                    Optional<BookingStatus> isValidBStatus= tripBookingService.getBookingStatusById(newIdStatus);
    
                    if (isValidBStatus.isEmpty()) {
                        System.out.println("ID DE VUELO NO VALIDO. EL VUELO NO EXISTE.");
                        return; 
                    }
    
                    TripBooking newTripBooking = new TripBooking(finalId, fechaReserva, newIdTrip, newIdStatus, newIdCustomer);
                    tripBookingService.createTripBooking(newTripBooking);
                    System.out.println("RESERVA DE VUELO CREADA EXITOSAMENTE!");
                }
            );
    
            System.out.println("DESEA AÑADIR OTRA RESERVA DE VUELO? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }
    
    

    public void searchTripBooking() {
        System.out.println("*************** BUSCAR RESERVA DE VUELO ***************");
        System.out.println("[?] DIGITE EL NUMERO DE LA OPCION QUE DESEA REALIZAR:");
        System.out.println("[1]. CONSULTAR LA RESERVA DE VUELO POR ID");
        System.out.println("[2]. REVISAR EL TRAYECTO POR ID");
        System.out.println("[3]. REVISAR LA TARIFA DE VUELO POR ID");
        System.out.println("SELECCIONE UNA OPCION: ");
        
        String option = sc.nextLine();
        
        switch (option) {
            case "1":
                searchTripBookingById();
                break;
            case "2":
                searchFlightConnection();
                break;
            case "3":
                searchFlightFareById();
                break;
            default:
                System.out.println(" OPCION NO VALIDA. POR FAVOR SELECCIONE 1, 2 O 3.");
                sc.nextLine();
                break;
        }
        
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
    
    private void searchTripBookingById() {
        List<TripBooking> tripBookings = tripBookingService.getAllTripBookings();
    
        if  (tripBookings.isEmpty())  {
            System.out.println("NO HAY NINGUNA RESERVA DE VUELO REGISTRADA");
            sc.nextLine();
        } else {
            System.out.println("*************** BUSCAR RESERVA DE VUELO ***************");
            System.out.println("INGRESE EL ID DE LA RESERVA DE VUELO A BUSCAR: ");
            String findId = sc.nextLine();
    
            Optional<TripBooking> tripBooking = tripBookingService.getTripBookingById(findId);
            tripBooking.ifPresentOrElse(
                t -> {
                    System.out.println("*************** RESERVA DE VUELO ***************");
                    System.out.println(MessageFormat.format(
                        "ID : {0}\nFECHA DE RESERVA : {1}\nID DE VUELO: {2}\nID DE ESTADO DE RESERVA: {3}\nID DEL CLIENTE: {4}", t.getId(), t.getBookingDate(), t.getIdTrip(), t.getIdBookingStatus(), t.getIdCustomer())); 
                    sc.nextLine();
                },
                () -> {
                    System.out.println("RESERVA DE VUELO NO ENCONTRADA");
                    sc.nextLine();
                }
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
    
    private void searchFlightFareById() {
        List<FlightFares> flightFares = tripBookingService.getAllFlightFares();
    
        if (flightFares.isEmpty()) {
            System.out.println("NO HAY NINGUNA TARIFA DE VUELO REGISTRADA");
            sc.nextLine();
        } else {
            System.out.println("*************** BUSCAR TARIFA DE VUELO ***************");
            System.out.println("INGRESE EL ID DEL VUELO DE VUELO A BUSCAR: ");
            String findIdFlare = sc.nextLine();  
    
            Optional<FlightFares> flightFare = tripBookingService.getFlightFaresById(findIdFlare);
            flightFare.ifPresentOrElse(
                tc -> {
                    System.out.println("*************** TARIFA DE VUELO ***************");
                    System.out.println(MessageFormat.format(" ID : {0}\n DESCRIPCION: {1}\nVALOR: {2}\n", tc.getId(), tc.getDescription(), tc.getValue()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("TARIFA DE VUELO NO ENCONTRADA");
                    sc.nextLine();
                }
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
    
    private void searchFlightConnection() {
    
        List<FlightConnection> flightConnections = tripBookingService.getAllFlightConnections();
        if (flightConnections.isEmpty()) {
            System.out.println("NO HAY NINGUN TRAMO REGISTRADO");
        } else {
            System.out.println("CONSULTAR INFORMACION DE TRAYECTO");
            System.out.println("\nINGRESE EL ID DEL VUELO AL QUE DESEA REVISAR EL TRAYECTO");
            String findIdTrip = sc.nextLine();
    
            Optional<FlightConnection> connection = tripBookingService.getFlightCOnnectionByTrip(findIdTrip);
    
            connection.ifPresentOrElse(
                f -> {
                    System.out.println(MessageFormat.format("\n ID : {0}\nORDEN : {1}\nVUELO : {2}\nAVION : {3}\nAEREOPUERTO SALIDA : {4}\nAEREOPUERTO LLEGADA : {5}", f.getId(), f.getConnectionOrder(), f.getIdTrip(), f.getIdPlane(), f.getIdAirportA(), f.getIdArportB()));
                },
                () -> {
                    System.out.println("\nNO SE ENCONTRO NINGUNA CONEXION RELACIONADA CON ESTE VUELO\n");
                }
            );
        }
    }
    
           
    

    public void updateTripBooking() {
        List<TripBooking> tripBookings = tripBookingService.getAllTripBookings();

        if (tripBookings.isEmpty()) {

            System.out.println("NO HAY RESERVA DE VUELO REGISTRADAS");

        } else {

            System.out.println("INGRESE EL ID DEL RESERVA DE VUELO A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<TripBooking> tripBooking = tripBookingService.getTripBookingById(findId);
            tripBooking.ifPresentOrElse(
            t -> {
                System.out.println(MessageFormat.format("ID : {0}\nFECHA DE RESERVA : {1}\nID DE VUELO: {2}\nID DE ESTADO DE RESERVA: {3}\n[ID DEL CLIENTE: {4}", t.getId(), t.getBookingDate() + t.getIdTrip(), t.getIdBookingStatus(), t.getIdCustomer()));

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate fechaReserva = null;
                        boolean isActiveDate = false;
                        String newDate = "";

                        while (!isActiveDate) {
                            System.out.println("\nINGRESE LA FECHA DE RESERVA DE VIAJE (dd-MM-yyyy)");
                            System.out.print("INGRESE LA FECHA DE RESERVA DE VIAJE: ");
                            newDate = sc.nextLine();

                            try {
                                fechaReserva = LocalDate.parse(newDate, formatter);
                                isActiveDate = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                            }
                        }
                        System.out.println("\nINGRESE EL ID DEL VUELO: ");
                        String newIdTrip = sc.nextLine();

                        System.out.println("\nINGRESE EL ID DEL ESTADO DE RESERVA: ");
                        int newIdStatus = Integer.parseInt(sc.nextLine());

                        System.out.println("\nINGRESE EL ID DEL CLIENTE: ");
                        String newIdCustomer = sc.nextLine();

                        TripBooking newTripBooking = new TripBooking(findId, fechaReserva, newIdTrip, newIdStatus,
                                newIdCustomer);
                        tripBookingService.updateTripBooking(newTripBooking);
                    },
                    () -> System.out.println("RESERVA DE VIAJE NO ENCONTRADA"));
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void deleteTripBooking() {
        List<TripBooking> tripBookings = tripBookingService.getAllTripBookings();
        if (tripBookings.isEmpty()) {
            System.out.println("NO HAY NINGUNA RESERVA DE VUELO REGISTRADA");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DE LA RESERVA DE VUELO A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<TripBooking> tripBooking = tripBookingService.getTripBookingById(findId);
            tripBooking.ifPresentOrElse(
                c -> {
                    tripBookingService.deleteTripBooking(findId);
                    System.out.println("RESERVA DE VUELO ELIMINADA CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("RESERVA DE VUELO NO ENCONTRADO");

                    });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllTripBookings() {
        List<TripBooking> TripBookings = tripBookingService.getAllTripBookings();

        if (TripBookings.isEmpty()) {
            System.out.println("NO HAY NINGUNA RESERVA DE VUELO REGISTRADO");
            sc.nextLine();
        } else {
            tripBookingService.getAllTripBookings().forEach(t -> {
                System.out.println(MessageFormat.format("ID : {0}\nFECHA DE RESERVA : {1}\nID DE VUELO: {2}\nID DE ESTADO DE RESERVA: {3}\nID DEL CLIENTE: {4}", t.getId(), t.getBookingDate() + t.getIdTrip(), t.getIdBookingStatus(), t.getIdCustomer()));
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllCustomers() {
        List<Customer> customers = tripBookingService.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("NO HAY NINGUN CLIENTE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("VUELOS DISPONIBLES");
            customers.forEach(c -> {
                System.out.println(
                        MessageFormat.format("ID : {0} - : {1}", c.getId(), c.getName() + c.getLastName()));
            });
        }
    }

    static boolean isActiveSel = true;
    static int seatNumber = 0;
    static LocalDate fechaReserva = null;
    public void selectTripBooking() {
        isActiveSel = true;
        while (isActiveSel) {
            System.out.println("INGRESE UN ID PARA LA RESERVA DE VUELO");
            String id = sc.nextLine();
            tripBookingService.getTripBookingById(id).ifPresentOrElse(
                    tb -> {
                        System.out.println(MessageFormat.format("EL ID {0} YA ESTA OCUPADO.", tb.getId()));
                    },
                    () -> {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        boolean isActiveDate = false;
                        String newDate = "";

                        while (!isActiveDate) {
                            System.out.println("\nINGRESE LA FECHA DE RESERVA DE VIAJE (dd-MM-yyyy)");
                            System.out.print("INGRESE LA FECHA DE RESERVA DE VIAJE: ");
                            newDate = sc.nextLine();

                            try {
                                fechaReserva = LocalDate.parse(newDate, formatter);
                                isActiveDate = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                            }
                        }

                        System.out.println("SELECCIONE UN VUELO: ");
                        tripBookingService.getAllTrips().forEach(v -> {
                            System.out.println(MessageFormat.format("[{0}] - {1}", v.getId(), v.getTripDate()));
                        });
                        System.out.println("INGRESE EL ID DEL VUELO: ");
                        String idTrip = sc.nextLine();

                        System.out.println("CLIENTES: ");
                        if (tripBookingService.getAllCustomers().isEmpty()) {
                            System.out.println("NO HAY NINGUN CLIENTE REGISTRADO");
                            System.out.println("DESEA REGISTRAR UN CLIENTE?  [S/N]");
                            String answer = sc.nextLine();
                            if (answer.equalsIgnoreCase("S")) {
                                CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(
                                        customerService);
                                customerConsoleAdapter.createCustomer();
                                isActiveSel = false;
                            }

                        } else {
                            tripBookingService.getAllCustomers().forEach(c -> {
                                System.out.println(
                                        MessageFormat.format("[{0}] - {1}", c.getId(), c.getName() + c.getLastName()));
                            });

                        }
                        System.out.println("INGRESE EL ID DEL PASAJERO: ");
                        String idCustomer = sc.nextLine();


                        System.out.println("AVIONES DISPONIBLES");
                        tripBookingService.getAllAirplanes().forEach(
                                p -> {
                                    System.out.println(MessageFormat.format("[{0}] - {1}", p.getId(), p.getPlates()));
                                });

                        System.out.println("INGRESE EL ID DEL AVION");
                        String planeId = sc.nextLine();
                        tripBookingService.getPlaneById(planeId).ifPresentOrElse(
                                a -> {

                                    Optional<Plane> avion = tripBookingService.getPlaneById(planeId);
                                    avion.ifPresentOrElse(
                                            p -> {
                                                System.out.println("MAPA DE ASIENTOS DISPONIBLES DEL AVION");

                                                int numAsientos = tripBookingService.getCapacity(planeId);
                                                ArrayList<Object> mapa = new ArrayList<>();

                                                for (int i = 1; i < numAsientos; i++) {
                                                    mapa.add(i);
                                                }

                                                for (int i = 0; i < mapa.size(); i++) {
                                                    System.out.print(mapa.get(i) + "\t");
                                                    if ((i + 1) % 8 == 0) {
                                                        System.out.println();
                                                    }
                                                }
                                                System.out.println("\nINGRESA EL NUMERO DE ASIENTO: ");
                                                seatNumber = Integer.parseInt(sc.nextLine());
                                                mapa.remove(seatNumber);

                                                System.out.println("SELECCIONE EL ESTADO DE LA RESERVA");
                                                int j = 1;
                                                for (String bs : tripBookingService.getAllBookingStatusesStr()) {
                                                    System.out.println(MessageFormat.format("{0} . {1}", j++, bs));
                                                }
                                                int bookingStatus = Integer.parseInt(sc.nextLine());

                                                TripBooking newTripBooking = new TripBooking(id, fechaReserva, idTrip, bookingStatus, idCustomer);
                                                tripBookingService.createTripBooking(newTripBooking);

                                                System.out.println("LA RESERVA HA SIDO CREADA EXITOSAMENTE.");
                                                sc.nextLine();

                                                isActiveSel = false;

                                            }, () -> {
                                                System.out.println("NO SE ENCONTRO EL AVION");
                                                sc.nextLine();
                                                isActiveSel = false;
                                            });
                                },
                                () -> {
                                    System.out.println(
                                            "NO SE HA ENCONTRADO EL CLIENTE. DESEAS REGISTRAR UNO NUEVO?  [S/N]");
                                    String respuesta = sc.nextLine();
                                    if (respuesta.equalsIgnoreCase("S")) {
                                        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(
                                                customerService);

                                        customerConsoleAdapter.createCustomer();
                                    } else {
                                        isActiveSel = false;
                                    }
                                });
                    });
        }
    }

    public void cancelTripBooking() {
        List<TripBooking> bookings = tripBookingService.getAllTripBookings();
        
        if (bookings.isEmpty()) {
            System.out.println("NO HAY NINGUNA RESERVA CREADA.");
            sc.nextLine();
        } else {
            System.out.println("RESERVAS REGISTRADAS");
            bookings.forEach(tb -> {
                System.out.println(MessageFormat.format("[{0}] - {1}", tb.getId(), tb.getIdBookingStatus()));
            });

            System.out.println("INGRESA EL ID DE LA RESERVA A CANCELAR: ");
            String idCancel = sc.nextLine();
            Optional<TripBooking> matchTrip = tripBookingService.getTripBookingById(idCancel);
            matchTrip.ifPresentOrElse(tb -> {
                tripBookingService.cancelTripBooking(idCancel);
                System.out.println(MessageFormat.format("LA RESERVA IDENTIFICADA : {0} HA SIDO CANCELADA!", tb.getId()));
                sc.nextLine();
            }, null); 
        }
    }
}
