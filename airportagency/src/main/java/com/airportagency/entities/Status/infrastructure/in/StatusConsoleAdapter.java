package com.airportagency.entities.Status.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.airportagency.entities.Status.application.StatusService;
import com.airportagency.entities.Status.domain.entity.Status;

public class StatusConsoleAdapter {

    Scanner sc = new Scanner(System.in);

    private final StatusService statusService;

    

    public StatusConsoleAdapter(StatusService statusService) {
        this.statusService = statusService;
    }



    public void createStatus(){
        String option = "S";
    
        while(option.equalsIgnoreCase("S")){
            System.out.println("REGISTRAR ESTADO");
            System.out.println("INGRESE EL ID DEL ESTADO");
            String idStatus = sc.nextLine();
            Optional<Status> status = statusService.getStatusById(idStatus);
            status.ifPresentOrElse(
                s -> {
                    System.out.println(MessageFormat.format("EL ID (0) DE ESTADO YA ESTA OCUPADO.", s.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR ESTADO");
                    System.out.println("INGRESE EL NOMBRE DEL ESTADO: ");
                    String statusName = sc.nextLine();
    
                    Status newStatus = new Status(idStatus, statusName);
                    statusService.createStatus(newStatus);
                    System.out.println("ESTADO CREADO CORRECTAMENTE");
                }
            );
            System.out.println(" DESEA CREAR OTRO ESTADO? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
    


    public void searchStatus(){
        List<Status> statuses = statusService.getAllStatuses();

        if (statuses.isEmpty()){
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR ESTADO");
            System.out.println("INGRESE EL ID DEL ESTADO A BUSCAR: ");
            String findId = sc.nextLine();


            Optional<Status> status = statusService.getStatusById(findId);
            status.ifPresentOrElse(
                s -> {
                    System.out.println("ESTADO");
                    System.out.println(MessageFormat.format("ID : {0}\n ESTADO : {1}", s.getId(), s.getStatus()));
                    sc.nextLine();
                },
                () -> {
                    System.out.println("ESTADO NO ENCONTRADO");
                    sc.nextLine();
                });
                System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                sc.nextLine();
        }
    }



    public void updateStatus() {
        List<Status> statuses = statusService.getAllStatuses();

        if (statuses.isEmpty()) {
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL ESTADO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Status> status = statusService.getStatusById(findId);
            status.ifPresentOrElse(
            s -> {
                System.out.println("ACTUALIZAR ESTADO");
                System.out.println(MessageFormat.format("ID : {0}\nESTADO : {1}", s.getId(), s.getStatus()));

                System.out.println("INGRESE EL NOMBRE DEL ESTADO : ");
                String updateStatus = sc.nextLine();

                Status updatedStatus = new Status(findId, updateStatus);
                statusService.updateStatus(updatedStatus);

                System.out.println("ESTADO ACTUALIZADO CORRECTAMENTE.");
                sc.nextLine();
            },
            () -> {
                System.out.println("ESTADO NO ENCONTRADO");
                sc.nextLine();
            }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }


    public void deleteStatus(){
        List<Status> statuses = statusService.getAllStatuses();

        if (statuses.isEmpty()){
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();        
        } else {
            System.out.println("INGRESE EL ID DEL ESTADO A ELIMINAR: ");
            String findId = sc.nextLine();


            Optional<Status> status = statusService.getStatusById(findId);
            status.ifPresentOrElse(
                s -> {
                    statusService.deleteStatus(findId);
                    System.out.println("ESTADO ELIMINADO CORRECTAMENTE.");
                    sc.nextLine();
                },
                () -> {
                    System.out.println("EL ESTADO NO EXISTE");
                }
            );
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }

    public void getAllStatuses(){
        List<Status> statuses = statusService.getAllStatuses();

        if (statuses.isEmpty()) {
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            statusService.getAllStatuses().forEach(s -> {
                System.out.println(MessageFormat.format("ID : {0}\n ESTADO : {1}", s.getId(), s.getStatus())); 
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

