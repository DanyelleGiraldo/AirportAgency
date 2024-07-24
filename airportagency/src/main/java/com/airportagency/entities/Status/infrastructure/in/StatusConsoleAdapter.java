package com.airportagency.entities.Status.infrastructure.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Status.application.StatusCreateService;
import com.airportagency.entities.Status.application.StatusDeleteService;
import com.airportagency.entities.Status.application.StatusGetAllService;
import com.airportagency.entities.Status.application.StatusSearchService;
import com.airportagency.entities.Status.application.StatusUpdateService;
import com.airportagency.entities.Status.domain.entity.Status;

public class StatusConsoleAdapter {

    Scanner sc = new Scanner(System.in);

    private final StatusCreateService statusCreateService;
    private final StatusUpdateService statusUpdateService;
    private final StatusDeleteService statusDeleteService;
    private final StatusGetAllService statusGetAllService;
    private final StatusSearchService statusSearchService;    

    public StatusConsoleAdapter(StatusCreateService statusCreateService, StatusUpdateService statusUpdateService,
            StatusDeleteService statusDeleteService, StatusGetAllService statusGetAllService,
            StatusSearchService statusSearchService) {
        this.statusCreateService = statusCreateService;
        this.statusUpdateService = statusUpdateService;
        this.statusDeleteService = statusDeleteService;
        this.statusGetAllService = statusGetAllService;
        this.statusSearchService = statusSearchService;
    }

    public void createStatus(){
        String option = "S";
    
        while(option.equalsIgnoreCase("S")){
            System.out.println("REGISTRAR ESTADO");
            System.out.println("INGRESE EL ID DEL ESTADO");
            String idStatus = sc.nextLine();
            Optional<Status> status = statusSearchService.getStatusById(idStatus);
            status.ifPresentOrElse(
                s -> {
                    System.out.println(MessageFormat.format("EL ID (0) DE ESTADO YA ESTA OCUPADO.", s.getId()));
                },
                () -> {
                    System.out.println("REGISTRAR ESTADO");
                    System.out.println("INGRESE EL NOMBRE DEL ESTADO: ");
                    String statusName = sc.nextLine();
    
                    Status newStatus = new Status(idStatus, statusName);
                    statusCreateService.createStatus(newStatus);
                    System.out.println("ESTADO CREADO CORRECTAMENTE");
                }
            );
            System.out.println(" DESEA CREAR OTRO ESTADO? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
    


    public void searchStatus(){
        List<Status> statuses = statusGetAllService.getAllStatuses();

        if (statuses.isEmpty()){
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("BUSCAR ESTADO");
            System.out.println("INGRESE EL ID DEL ESTADO A BUSCAR: ");
            String findId = sc.nextLine();


            Optional<Status> status = statusSearchService.getStatusById(findId);
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
        List<Status> statuses = statusGetAllService.getAllStatuses();

        if (statuses.isEmpty()) {
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            System.out.println("INGRESE EL ID DEL ESTADO A BUSCAR: ");
            String findId = sc.nextLine();

            Optional<Status> status = statusSearchService.getStatusById(findId);
            status.ifPresentOrElse(
            s -> {
                System.out.println("ACTUALIZAR ESTADO");
                System.out.println(MessageFormat.format("ID : {0}\nESTADO : {1}", s.getId(), s.getStatus()));

                System.out.println("INGRESE EL NOMBRE DEL ESTADO : ");
                String updateStatus = sc.nextLine();

                Status updatedStatus = new Status(findId, updateStatus);
                statusUpdateService.updateStatus(updatedStatus);

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
        List<Status> statuses = statusGetAllService.getAllStatuses();

        if (statuses.isEmpty()){
            System.out.println("NO HAY NINGUN PAIS REGISTRADO");
            sc.nextLine();        
        } else {
            System.out.println("INGRESE EL ID DEL ESTADO A ELIMINAR: ");
            String findId = sc.nextLine();


            Optional<Status> status = statusSearchService.getStatusById(findId);
            status.ifPresentOrElse(
                s -> {
                    statusDeleteService.deleteStatus(findId);
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
        List<Status> statuses = statusGetAllService.getAllStatuses();

        if (statuses.isEmpty()) {
            System.out.println("NO HAY NINGUN ESTADO REGISTRADO");
            sc.nextLine();
        } else {
            statusGetAllService.getAllStatuses().forEach(s -> {
                System.out.println(MessageFormat.format("ID : {0}\n ESTADO : {1}", s.getId(), s.getStatus())); 
            });
            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
            sc.nextLine();
        }
    }
}

