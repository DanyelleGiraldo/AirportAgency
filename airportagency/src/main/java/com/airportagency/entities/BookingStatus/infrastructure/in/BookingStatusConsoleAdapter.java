package com.airportagency.entities.BookingStatus.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.BookingStatus.application.BookingStatusCreateService;
import com.airportagency.entities.BookingStatus.application.BookingStatusGetAllService;
import com.airportagency.entities.BookingStatus.application.BookingStatusSearchService;
import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;

public class BookingStatusConsoleAdapter {
    Scanner sc = new Scanner(System.in);
    private final BookingStatusCreateService bookingStatusCreateService;
    private final BookingStatusSearchService bookingStatusSearchService;
    private final BookingStatusGetAllService bookingStatusGetAllService;

    public BookingStatusConsoleAdapter(BookingStatusCreateService bookingStatusCreateService,
            BookingStatusSearchService bookingStatusSearchService,
            BookingStatusGetAllService bookingStatusGetAllService) {
        this.bookingStatusCreateService = bookingStatusCreateService;
        this.bookingStatusSearchService = bookingStatusSearchService;
        this.bookingStatusGetAllService = bookingStatusGetAllService;
    } 
    public void createBookingStatus() {
        String rta = "S";

        while (rta.equalsIgnoreCase("S")) {
            System.out.println("*************** REGISTRAR ESTADO DE RESERVA ***************");
            System.out.println("[*] INGRESE EL ID DEL ESTADO DE RESERVA A CREAR: ");
            int id = sc.nextInt();
            Optional<BookingStatus> bookingStatus = bookingStatusSearchService.getBookingStatusById(id);
            bookingStatus.ifPresentOrElse(
                a -> {
                    System.out.println(MessageFormat.format("[!] EL ID (0) YA ESTA OCUPADO.", a.getId()));
                },
                () -> {
                    System.out.println("*************** REGISTRAR ESTADO DE RESERVA ***************");

                    System.out.println("[*] INGRESE EL NOMBRE DEL ESTADO DE RESERVA: ");
                    String bookingStatusName = sc.nextLine();
    
                    BookingStatus newBookingStatus = new BookingStatus(id, bookingStatusName);
                    bookingStatusCreateService.createBookingStatus(newBookingStatus);
                });

            System.out.println("[?] DESEA AÑADIR OTRO ESTADO DE RESERVA? [S] - SI | [INGRESE CUALQUIER TECLA] - NO");
            rta = sc.nextLine();
        }
    }

    public void searchBookingStatus() {
        List<BookingStatus> bookingStatuses = bookingStatusGetAllService.getAllBookingStatus();
        
        if (bookingStatuses.isEmpty()) {
            System.out.println("[!] NO HAY NINGUN ESTADO DE RESERVA REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("*************** BUSCAR ESTADO DE RESERVA ***************");
            System.out.println("[?] INGRESE EL ID DEL ESTADO DE RESERVA A BUSCAR: ");
            int findId = sc.nextInt();

            Optional<BookingStatus> bookingStatus = bookingStatusSearchService.getBookingStatusById(findId);
            bookingStatus.ifPresentOrElse(
                e -> {
                    System.out.println("*************** ESTADO DE RESERVA ***************");
                    System.out.println(MessageFormat.format("[*] ID : {0}\n[*] ESTADO : {1}", e.getId(), e.getBookingStatus()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("[!]  ESTADO DE RESERVA NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("[*]  PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }

    public void getAllBookingStatuss() {
        List<BookingStatus> bookingStatuses = bookingStatusGetAllService.getAllBookingStatus();
        
        if (bookingStatuses.isEmpty()) {
            System.out.println("[!] NO HAY NINGUN ESTADO DE RESERVA REGISTRADO");
            sc.nextLine();
        } else {
            bookingStatusGetAllService.getAllBookingStatus().forEach(e -> {
               System.out.println(MessageFormat.format("[*] ID : {0}\n[*] ESTADO : {1}", e.getId(), e.getBookingStatus())); 
            });
            System.out.println("[*]  PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
    
}
