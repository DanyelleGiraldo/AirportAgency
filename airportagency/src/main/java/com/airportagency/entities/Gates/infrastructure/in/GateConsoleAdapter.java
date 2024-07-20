package com.airportagency.entities.Gates.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Gates.application.GateCreateService;
import com.airportagency.entities.Gates.application.GateDeleteService;
import com.airportagency.entities.Gates.application.GateGetAllService;
import com.airportagency.entities.Gates.application.GateSearchService;
import com.airportagency.entities.Gates.application.GateUpdateService;
import com.airportagency.entities.Gates.domain.entity.Gates;

public class GateConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final GateCreateService gateCreateService;
    private final GateDeleteService gateDeleteService;
    private final GateUpdateService gateUpdateService;
    private final GateSearchService gateSearchService;
    private final GateGetAllService gateGetAllService;

    public GateConsoleAdapter(GateCreateService gateCreateService, GateDeleteService gateDeleteService,
            GateUpdateService gateUpdateService, GateSearchService gateSearchService,
            GateGetAllService gateGetAllService) {
        this.gateCreateService = gateCreateService;
        this.gateDeleteService = gateDeleteService;
        this.gateUpdateService = gateUpdateService;
        this.gateSearchService = gateSearchService;
        this.gateGetAllService = gateGetAllService;
    }

    public void createGates(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DE LA COMPUERTA");
            String newId = sc.nextLine();

            Optional<Gates> gate = gateSearchService.getGateById(newId);
            gate.ifPresentOrElse(
                g ->  {
                    System.out.println("AIROLINEA YA EXISTENTE");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    sc.nextLine();
                },
                ()-> {
                    System.out.println("\nINGRESE EL NOMBRE DE LA COMPUERTA");
                    String newGate = sc.nextLine();

                    System.out.println("\nINGRESE EL ID DEL AEROPUERTO CORRESPONDIENTE");
                    String newIdAirport = sc.nextLine();


                    Gates gates = new Gates(newId, newGate, newIdAirport);
                    gateCreateService.createGate(gates);
                }
            );
            System.out.println("DESEA CREAR OTRA COMPUERTA? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();   
        }  
    }

    public void searchGates(){
        List<Gates> gateList = gateGetAllService.getAllGates();

        if(gateList.isEmpty()){
            System.out.println("NO HAY COMPUERTAS REGISTRADAS");
        }else {
            System.out.println("INGRESE EL ID DE LA COMPUERTA\n\n");
            String findId = sc.nextLine();

            Optional<Gates> gates = gateSearchService.getGateById(findId);
            gates.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n COMPUERTA: " + f.getGate() + "\n ID DEL AEROPUERTO: " + f.getIdAirport()),
                () -> System.out.println("COMPUERTA NO ENCONTRADA")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updateGate(){
        List<Gates> gateList = gateGetAllService.getAllGates();

        if(gateList.isEmpty()){

            System.out.println("NO HAY COMPUERTAS REGISTRADAS");

        }  else {

            System.out.println("INGRESE EL ID DE LA COMPUERTA A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<Gates> gate = gateSearchService.getGateById(findId);
            gate.ifPresentOrElse(
            f -> {
                System.out.println(" ID: "+ f.getId() + "\n COMPUERTA: " + f.getGate() + "\n ID DEL AEROPUERTO: " + f.getIdAirport());

                String updateId = f.getId();

                System.out.println("INGRESE EL NUEVO NOMBRE DE LA COMPUERTA");
                String updateName = sc.nextLine();

                System.out.println("INGRESE EL NUEVO NOMBRE DEL AEROPUERTO CORRESPONDIENTE");
                String updateIdAirport = sc.nextLine();

                Gates updateGates = new Gates (updateId,updateName, updateIdAirport);
                gateUpdateService.updateGate(updateGates);
            },
            () -> System.out.println("COMPUERTA NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
        }
    }

    public void deletegates(){
        List<Gates> gate = gateGetAllService.getAllGates();
        if(gate.isEmpty()){
            System.out.println("NO HAY COMPUERTAS REGISTRADAS");
        }   else {
            System.out.println("INGRESE EL ID DE LA COMPUERTA A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<Gates> gates = gateSearchService.getGateById(findId);
            gates.ifPresentOrElse(
                f -> gateDeleteService.deleteGates(findId),
                () -> System.out.println("COMPUERTA NO ENCONTRADA")
            );
        } 
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllGates(){
        List<Gates> gates = gateGetAllService.getAllGates();
        if(gates.isEmpty()){
            System.out.println("NO HAY COMPUERTAS REGISTRADAS");
        } else {
            gateGetAllService.getAllGates().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\n COMPUERTA: " + f.getGate() + "\n ID DEL AEROPUERTO: " + f.getIdAirport());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
}
