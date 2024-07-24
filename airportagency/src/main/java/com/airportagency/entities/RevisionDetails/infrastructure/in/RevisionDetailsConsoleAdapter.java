package com.airportagency.entities.RevisionDetails.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.RevisionDetails.application.RevisionDetailsService;
import com.airportagency.entities.RevisionDetails.domain.entity.RevisionDetails;

public class RevisionDetailsConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private final RevisionDetailsService RevisionDetailsService;

    public RevisionDetailsConsoleAdapter(RevisionDetailsService RevisionDetailsService) {
        this.RevisionDetailsService = RevisionDetailsService;
    }

    public void createRevisionDetail(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DE LOS DETALLES DE REVISION");
            String newId = sc.nextLine();

            Optional<RevisionDetails> RevisionDetails = RevisionDetailsService.findById(newId);
            RevisionDetails.ifPresentOrElse(
                g ->  {
                    System.out.println("DETALLES DE REVISION YA EXISTENTES");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    sc.nextLine();
                },
                ()-> {

                    System.out.println("\nINGRESE LA DESCRIPCION");
                    String newDescription = sc.nextLine();

                    System.out.println("\nINGRESE EL ID DEL EMPLEADO");
                    String newIdEmployee = sc.nextLine();
                      
                    RevisionDetails revisionDetails = new RevisionDetails(newId, newDescription, newIdEmployee);
                    RevisionDetailsService.createRevisionDetail(revisionDetails);
                }
            );
            System.out.println("DESEA REGISTRAR OTRA DESCRIPCION? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();   
        }  
    }

    public void searchRevisionDetail(){
        List<RevisionDetails> revisionDetailsList = RevisionDetailsService.findAll();

        if(revisionDetailsList.isEmpty()){
            System.out.println("NO HAY DETALLES DE REVISIONES REGISTRADAS");
        }else {
            System.out.println("INGRESE EL ID DEL DETALLE DE REVISION\n\n");
            String findId = sc.nextLine();

            Optional<RevisionDetails> RevisionDetails = RevisionDetailsService.findById(findId);
            RevisionDetails.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n DESCRIPCION: " + f.getDescription() + "\nID DEL EMPLEADO: " + f.getIdEmployee()),
                () -> System.out.println(" REVISION NO ENCONTRADA")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updateRevisionDetails(){
        List<RevisionDetails> RevisionDetailsList = RevisionDetailsService.findAll();

        if(RevisionDetailsList.isEmpty()){

            System.out.println("NO HAY DETALLES DE REVISIONES REGISTRADAS");

        }  else {

            System.out.println("INGRESE EL ID DE LOS DETALLES DE LA REVISION A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<RevisionDetails> revisionDetails = RevisionDetailsService.findById(findId);
            revisionDetails.ifPresentOrElse(
            f -> {
                System.out.println(" ID: "+ f.getId() + "\nDESCRIPCION: " + f.getDescription() + "\nID DEL EMPLEADO: " + f.getIdEmployee());

                String updateId = f.getId();

                System.out.println("INGRESE LA NUEVA DESCRIPCION");
                String updateDetails = sc.nextLine();

                System.out.println("INGRESE EL NUEVO ID DEL EMPLEADO");
                String updateIdEmpleado = sc.nextLine();

                RevisionDetails updateRevisionDetails = new RevisionDetails (updateDetails, updateIdEmpleado,updateId);
                RevisionDetailsService.updateRevisionDetail(updateRevisionDetails);
            },
            () -> System.out.println("DETALLES DE REVISION NO ENCONTRADA")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
        }
    }

    public void deleteRevisionDetails(){
        List<RevisionDetails> RevisionDetail = RevisionDetailsService.findAll();
        if(RevisionDetail.isEmpty()){
            System.out.println("NO HAY DETALLES REVISIONES REGISTRADAS");
        }   else {
            System.out.println("INGRESE EL ID DE LOS DETALLES DE LA REVISION A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<RevisionDetails> RevisionDetails = RevisionDetailsService.findById(findId);
            RevisionDetails.ifPresentOrElse(
                f -> RevisionDetailsService.deleteRevisionDetails(findId),
                () -> System.out.println("DETALLES DE REVISION NO ENCONTRADA")
            );
        } 
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllRevisionDetails(){
        List<RevisionDetails> RevisionDetails = RevisionDetailsService.findAll();
        if(RevisionDetails.isEmpty()){
            System.out.println("NO HAY DETALLES DE REVISIONES REGISTRADAS");
        } else {
            RevisionDetailsService.findAll().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\n DESCRIPCION: " + f.getDescription() + "\n ID DEL EMPLEADO: " + f.getIdEmployee());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }
}
