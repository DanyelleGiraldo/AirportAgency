package com.airportagency.entities.FlightFares.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.FlightFares.application.FlightFareCreateService;
import com.airportagency.entities.FlightFares.application.FlightFareDeleteService;
import com.airportagency.entities.FlightFares.application.FlightFareGetAllService;
import com.airportagency.entities.FlightFares.application.FlightFareSerchService;
import com.airportagency.entities.FlightFares.application.FlightFareUpdateService;
import com.airportagency.entities.FlightFares.domain.entity.FlightFares;

public class FlightFareConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final FlightFareCreateService flightFareCreateService;
    private final FlightFareDeleteService flightFareDeleteService;
    private final FlightFareUpdateService flightFareUpdateService;
    private final FlightFareSerchService flightFareSerchService;
    private final FlightFareGetAllService flightFareGetAllService;

    public FlightFareConsoleAdapter(FlightFareCreateService flightFareCreateService,
            FlightFareDeleteService flightFareDeleteService, FlightFareUpdateService flightFareUpdateService,
            FlightFareSerchService flightFareSerchService, FlightFareGetAllService flightFareGetAllService) {
        this.flightFareCreateService = flightFareCreateService;
        this.flightFareDeleteService = flightFareDeleteService;
        this.flightFareUpdateService = flightFareUpdateService;
        this.flightFareSerchService = flightFareSerchService;
        this.flightFareGetAllService = flightFareGetAllService;
    }

    public void createFlightFare(){
        String option = "S";
        while (option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DE LA TARIFA DE VUELO. EJEMPLO: FF12");
            String newId = sc.nextLine();
            Optional<FlightFares> flightFare = flightFareSerchService.getFlightFareById(newId);
            flightFare.ifPresentOrElse(
                f -> {
                    System.out.println("TARIFA DE VUELO YA EXISTENTE");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    sc.nextLine();
                }, 
                () -> {
                    System.out.println("\nINGRESA UNA DESCRIPCION");
                    String newDescription = sc.nextLine();
    
                    System.out.println("\nINGRESE LOS DETALLES");
                    String newDetails = sc.nextLine();
    
                    System.out.println("\nINGRESE EL VALOR DE LA TARIFA DE VUELO");
                    String valueInput = sc.nextLine();
                    Double newValue = null;
                    try {
                        newValue = Double.parseDouble(valueInput);
                    } catch (NumberFormatException e) {
                        System.out.println("VALOR INVALIDO. INTENTE NUEVAMENTE.");
                        return;
                    }
    
                    FlightFares flightfare = new FlightFares(newId, newDescription, newDetails, newValue);
                    flightFareCreateService.createFlightFare(flightfare);
                }
            );
            System.out.println("DESEA CREAR OTRA TARIFA DE VUELO? [S] SI \n [CUALQUIER TECLA] NO");
            option = sc.nextLine(); 
        }
    }
    

    public void searchFlightFare(){
        List<FlightFares> flightFaresList = flightFareGetAllService.getAllFlightFares();

        if(flightFaresList.isEmpty()){

            System.out.println("NO HAY TARIFAS DE VUELO REGISTRADAS");
        }   else {

            System.out.println("INGRESE EL ID DE LA TARIFA DE VUELO\n\n");
            String findId = sc.nextLine();
    
            Optional<FlightFares> flightfare = flightFareSerchService.getFlightFareById(findId);
            flightfare.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n    DESCRIPCION: " + f.getDescription() + "\n    DETALLES: " + f.getDetails() + "\n    VALOR:  " + f.getValue()),
                () -> System.out.println("TARIFA DE VUELO NO ENCONTRADA")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updateFlightFare(){
        List<FlightFares> flightFaresList = flightFareGetAllService.getAllFlightFares();

        if(flightFaresList.isEmpty()){
            System.out.println("NO HAY TARIFAS DE VUELO REGISTRADAS");
        }   else {

            System.out.println("INGRESE EL ID DE LA TARIFA DE VUELO A EDITAR\n\n");
            String findId = sc.nextLine();
    
            Optional<FlightFares> flightFare = flightFareSerchService.getFlightFareById(findId);
            flightFare.ifPresentOrElse(
                f -> {
                    System.out.println("ID: "+ f.getId() + "\n DESCRIPCION: " + f.getDescription() + "\n   DETALLES: " + f.getDetails() + "\n VALOR:  " + f.getValue());
    
                    String updateId = f.getId();
    
                    System.out.println("INGRESE LA DESCRIPCION ACTUALIZADA");
                    String updateDescription = sc.nextLine();
    
                    System.out.println("INGRESE LOS DETALLES ACTUALIZADOS");
                    String updateDetails = sc.nextLine();
    
                    System.out.println("INGRESE EL NUEVO VALOR"); 
                    Double updateValues = sc.nextDouble();
    
                    FlightFares updatedFlightFare = new FlightFares(updateId, updateDescription, updateDetails, updateValues);
                    flightFareUpdateService.updateFlightFare(updatedFlightFare);
                },
                () -> System.out.println("TARIFA DE VUELO NO ENCONTRADA")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR");
        sc.nextLine();
    }

    public void deleteFlightFare(){
        List<FlightFares> flightFaresList = flightFareGetAllService.getAllFlightFares();

        if(flightFaresList.isEmpty()){
            System.out.println("NO HAY TARIFAS DE VUELO REGISTRADAS");
        }   else {
            getAllFlightFares();
            System.out.println("\nINGRESE EL ID DE LA TARIFA DE VUELO A ELIMINAR\n\n");
            String findId = sc.nextLine();
    
            Optional<FlightFares> flightfare = flightFareSerchService.getFlightFareById(findId);
            flightfare.ifPresentOrElse(
                f -> flightFareDeleteService.deleteFlighFare(findId),
                () -> System.out.println("TARIFA DE VUELO NO ENCONTRADA")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllFlightFares(){
        List<FlightFares> flightFaresList = flightFareGetAllService.getAllFlightFares();

        if(flightFaresList.isEmpty()){
            System.out.println("NO HAY TARIFAS DE VUELO REGISTRADAS");
        }   else {
            flightFareGetAllService.getAllFlightFares().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\n DESCRIPCION: " + f.getDescription() + "\n DETALLES: " + f.getDetails() + "\n VALOR:  " + f.getValue());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
}
