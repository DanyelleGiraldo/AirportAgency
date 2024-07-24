package com.airportagency.entities.PlaneModel.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.airportagency.entities.PlaneModel.application.PlaneModelService;
import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
public class PlaneModelConsoleAdapter {

    Scanner sc = new Scanner(System.in);

    private final PlaneModelService planeModelService;

    

    public PlaneModelConsoleAdapter(PlaneModelService planeModelService) {
        this.planeModelService = planeModelService;
    }

    public void createModels(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DEL MODELO");
            String newId = sc.nextLine();

            Optional<PlaneModels> models = planeModelService.findById(newId);
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
                    planeModelService.createPlaneModels(planes);
                }
            );
            System.out.println("DESEA REGISTRAR OTRO MODELO? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();   
        }  
    }

    public void searchModels(){
        List<PlaneModels> modelList = planeModelService.findAll();

        if(modelList.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        }else {
            System.out.println("INGRESE EL ID DEL MODELO\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> planeModels = planeModelService.findById(findId);
            planeModels.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer()),
                () -> System.out.println("MODELO NO ENCONTRADO")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updateModels(){
        List<PlaneModels> modelList = planeModelService.findAll();

        if(modelList.isEmpty()){

            System.out.println("NO HAY MODELOS REGISTRADOS");

        }  else {

            System.out.println("INGRESE EL ID DEL MODELO A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> model = planeModelService.findById(findId);
            model.ifPresentOrElse(
            f -> {
                System.out.println(" ID: "+ f.getId() + "\n MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer());

                String updateId = f.getId();

                System.out.println("INGRESE EL NUEVO NOMBRE DEL MODELO");
                String updateModel = sc.nextLine();

                System.out.println("INGRESE EL NUEVO ID DEL FABRICANTE CORRESPONDIENTE");
                String updateIdManufacturer = sc.nextLine();

                PlaneModels updatePlaneModels = new PlaneModels (updateModel, updateIdManufacturer,updateId);
                planeModelService.updatePlaneModels(updatePlaneModels);
            },
            () -> System.out.println("MODELO NO ENCONTRADO")
        );
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
        }
    }

    public void deletePlaneModels(){
        List<PlaneModels> models = planeModelService.findAll();
        if(models.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        }   else {
            System.out.println("INGRESE EL ID DEL MODELO A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<PlaneModels> planeModels = planeModelService.findById(findId);
            planeModels.ifPresentOrElse(
                f -> planeModelService.deletePlaneModels(findId),
                () -> System.out.println("MODELO NO ENCONTRADO")
            );
        } 
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllPlaneModels(){
        List<PlaneModels> planeModels = planeModelService.findAll();
        if(planeModels.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        } else {
            planeModelService.findAll().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\n  MODELO: " + f.getModel() + "\n ID DEL FABRICANTE: " + f.getIdManufacturer());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

}
