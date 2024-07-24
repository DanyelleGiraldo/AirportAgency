package com.airportagency.entities.tripbookindetails.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.tripbookindetails.application.TripBookingDetailsService;
import com.airportagency.entities.tripbookindetails.domain.entity.TripBookingDetails;

public class TripBookingDetailsConsoleAdapter {
     Scanner sc = new Scanner(System.in);

    private final TripBookingDetailsService tripBookingDetailsService;

    public TripBookingDetailsConsoleAdapter(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }



    public void createTripBookingDetails(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("*************** REGISTRAR DETALLES DE RESERVA ***************");
            System.out.println("INGRESE EL ID DE DETALLE DE RESERVA DE VIAJE");
            String newId =  sc.nextLine();
            Optional<TripBookingDetails> tripBookingDetails = tripBookingDetailsService.getTripBookingDetailsById(newId);
            tripBookingDetails.ifPresentOrElse(
                tb -> {
                    System.out.println(MessageFormat.format(" EL ID (0) YA ESTA OCUPADO.", tb.getId()));
                },
                () -> {
                    int seatNumber = 0;
                    System.out.println("*************** REGISTRAR DETALLES DE RESERVA DE VIAJE ***************");

                    System.out.println("INGRESE EL ID DE LA RESERVA VIAJE : ");
                    String idTripBking = sc.nextLine();
    
                    System.out.println("INGRESE EL ID DE TARIFA DE VUELO : ");
                    String idFlightFare = sc.nextLine();
            
                    TripBookingDetails newTripBookingDetails = new TripBookingDetails(newId, seatNumber, idTripBking, idFlightFare);
                    tripBookingDetailsService.createTripBookingDetails(newTripBookingDetails);
                    System.out.println("LOS DETALLES DE LA RESERVA DE VIAJE HAN SIDO REGISTRADOS CON EXITO");
                }
            );
            System.out.println("DESEA CREAR OTRO DETALLE DE RESERVA? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();                                                                                                                                                                                                                                                                                                        
        }
    }


    public void searchTripBookingDetails(){
        List<TripBookingDetails> tripBookingDetails = tripBookingDetailsService.getAllTripBookingDetails();

        if (tripBookingDetails.isEmpty()){
            System.out.println("NO HAY NINGUN DETALLE DE RESERVA DE VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("*************** BUSCAR DETALLE DE RESERVA DE VIAJE ***************");
            System.out.println("INGRESE EL ID DE DETALLES DE LA RESERVA DE VIAJE: ");
            String findId = sc.nextLine();

            Optional<TripBookingDetails> tripBookingDetail = tripBookingDetailsService.getTripBookingDetailsById(findId);
            tripBookingDetail.ifPresentOrElse(
                tb -> {
                    System.out.println("*************** DETALLES DE RESERVA ***************");
                    System.out.println(MessageFormat.format("ID : {0}\nID DE RESERVA DE VIAJE : {1}\nID DE CLIENTE: {2}\nID DE TARIFA DE VUELO: {3}", tb.getId(), tb.getIdTripBooking(), tb.getIdFlightFares()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("DETALLES DE RESERVA DE VIAJE NO ENCONTRADOS");
                    sc.nextLine();
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();

        }
        
    }


    public void updateTripBookingDetails() {
        List<TripBookingDetails> tripBookingDetails = tripBookingDetailsService.getAllTripBookingDetails();
    
        if (tripBookingDetails.isEmpty()) {
            System.out.println("NO HAY NINGUN DETALLE DE RESERVA VIAJE REGISTRADO");
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL DETALLE DE RESERVA VIAJE A BUSCAR: ");
            String findId = sc.nextLine();
    
            Optional<TripBookingDetails> tripBookingDetail = tripBookingDetailsService.getTripBookingDetailsById(findId);
            tripBookingDetail.ifPresentOrElse(
                tb -> {
                    int seatNumber = 0;
                    System.out.println("***** ACTUALIZAR DETALLES DE RESERVA VIAJE *****");
                    System.out.println(MessageFormat.format(
                        "ID: {0}\n ID DE RESERVA DE VIAJE: {1}\nID DE CLIENTE: {2}\nID DE TARIFAS DE VUELO: {3}",
                        tb.getId(), tb.getIdTripBooking(), tb.getIdFlightFares()
                    ));
                     System.out.println("INGRESE EL ID DE LA RESERVA VIAJE : ");
                    String idTripBking = sc.nextLine();
    
                    System.out.println("INGRESE EL ID DE TARIFA DE VUELO : ");
                    String idFlightFare = sc.nextLine();

                    TripBookingDetails updatedTripBookingDetails = new TripBookingDetails(findId, seatNumber, idTripBking, idFlightFare);
                    tripBookingDetailsService.updateTripBookingDetails(updatedTripBookingDetails);
                    sc.nextLine();

                    System.out.println("DETALLE DE RESERVA DE VIAJE ACTUALIZADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("DETALLE DE RESERVA DE VIAJE NO ENCONTRADO");
                    sc.nextLine();
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
    
    
    public void deleteTripBookingDetails(){
        List<TripBookingDetails> tripBookingDetails = tripBookingDetailsService.getAllTripBookingDetails();

        if (tripBookingDetails.isEmpty()){
            System.out.println("NO HAY DETALLES DE RESERVA DE VIAJE REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL DETALLE DE RESERVA DE VIAJE A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<TripBookingDetails> tripBookingDetail = tripBookingDetailsService.getTripBookingDetailsById(findId);
            tripBookingDetail.ifPresentOrElse(
                tb -> {
                    tripBookingDetailsService.deleteTripBookingDetails(findId);
                    System.out.println("DETALLE DE RESERVA DE VIAJE ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("DETALLE DE RESERVA DE VIAJE NO ENCONTRADO");
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }


    public void getAllTripBookingDetails(){
        List<TripBookingDetails> TripBookingDetails = tripBookingDetailsService.getAllTripBookingDetails();
        if(TripBookingDetails.isEmpty()){
            System.out.println("NO HAY DETALLES DE RESERVA DE VIAJE REGISTRADOS");
        }   else {
            System.out.println("DETALLES DE RESERVA DE VIAJE REGISTRADOS");
            tripBookingDetailsService.getAllTripBookingDetails().forEach(tb -> {
                System.out.println("ID: "+ tb.getId() + "ID DE RESERVA DE VIAJE: " + tb.getIdTripBooking() + "ID DE TARIFAS DE VUELO: " + tb.getIdFlightFares());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
       
        
    }
}
