package com.airportagency.entities.PlaneModel.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.PlaneModel.application.PlaneModelCreateService;
import com.airportagency.entities.PlaneModel.application.PlaneModelDeleteService;
import com.airportagency.entities.PlaneModel.application.PlaneModelGetAllService;
import com.airportagency.entities.PlaneModel.application.PlaneModelSearchService;
import com.airportagency.entities.PlaneModel.application.PlaneModelUpdateService;
import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
public class PlaneModelConsoleAdapter {

    Scanner sc = new Scanner(System.in);

    private final PlaneModelCreateService planeModelCreateService;
    private final PlaneModelDeleteService planeModelDeleteService;
    private final PlaneModelSearchService planeModelSearchService;
    private final PlaneModelGetAllService planeModelGetAllService;
    private final PlaneModelUpdateService planeModelUpdateService;

    public PlaneModelConsoleAdapter(PlaneModelCreateService planeModelCreateService,
            PlaneModelDeleteService planeModelDeleteService, PlaneModelSearchService planeModelSearchService,
            PlaneModelGetAllService planeModelGetAllService, PlaneModelUpdateService planeModelUpdateService) {
        this.planeModelCreateService = planeModelCreateService;
        this.planeModelDeleteService = planeModelDeleteService;
        this.planeModelSearchService = planeModelSearchService;
        this.planeModelGetAllService = planeModelGetAllService;
        this.planeModelUpdateService = planeModelUpdateService;
    }

    public void createModels(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DEL MODELO");
            String newId = sc.nextLine();

            Optional<PlaneModels> models = planeModelSearchService.getPlaneModelById(newId);
            models.ifPresentOrElse(
                g ->  {
                    System.out.println("EL MODELO YA EXISTENTE");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    sc.nextLine();
                },
                ()-> {

                    System.out.println("\n INGRESE EL MODELO");
                    String newModel = sc.nextLine();

                    System.out.println("\n INGRESE EL ID DEL FABRICANTE");
                    String newIdManufacturer = sc.nextLine();
                      
                    PlaneModels planes = new PlaneModels(newId, newModel, newIdManufacturer);
                    planeModelCreateService.createPlaneModel(planes);
                }
            );
            System.out.println("DESEA REGISTRAR OTRO MODELO? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();   
        }  
    }

    public void searchModels(){
        List<PlaneModels> modelList = planeModelGetAllService.getAllPlaneModels();

        if(modelList.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        }else {
            System.out.println("INGRESE EL ID DEL MODELO\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> planeModels = planeModelSearchService.getPlaneModelById(findId);
            planeModels.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer()),
                () -> System.out.println("MODELO NO ENCONTRADO")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updateModels(){
        List<PlaneModels> modelList = planeModelGetAllService.getAllPlaneModels();

        if(modelList.isEmpty()){

            System.out.println("NO HAY MODELOS REGISTRADOS");

        }  else {

            System.out.println("INGRESE EL ID DEL MODELO A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> model = planeModelSearchService.getPlaneModelById(findId);
            model.ifPresentOrElse(
            f -> {
                System.out.println(" ID: "+ f.getId() + "\n MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer());

                String updateId = f.getId();

                System.out.println("INGRESE EL NUEVO NOMBRE DEL MODELO");
                String updateModel = sc.nextLine();

                System.out.println("INGRESE EL NUEVO ID DEL FABRICANTE CORRESPONDIENTE");
                String updateIdManufacturer = sc.nextLine();

                PlaneModels updatePlaneModels = new PlaneModels (updateModel, updateIdManufacturer,updateId);
                planeModelUpdateService.updatePlaneModel(updatePlaneModels);
            },
            () -> System.out.println("MODELO NO ENCONTRADO")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
        }
    }

    public void deletePlaneModels(){
        List<PlaneModels> models = planeModelGetAllService.getAllPlaneModels();
        if(models.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        }   else {
            System.out.println("INGRESE EL ID DEL MODELO A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> planeModels = planeModelSearchService.getPlaneModelById(findId);
            planeModels.ifPresentOrElse(
                f -> planeModelDeleteService.deletePlaneModel(findId),
                () -> System.out.println("MODELO NO ENCONTRADO")
            );
        } 
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllPlaneModels(){
        List<PlaneModels> planeModels = planeModelGetAllService.getAllPlaneModels();
        if(planeModels.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        } else {
            planeModelGetAllService.getAllPlaneModels().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\n  MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

}
