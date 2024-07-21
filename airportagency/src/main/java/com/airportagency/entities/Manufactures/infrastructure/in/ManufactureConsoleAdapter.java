package com.airportagency.entities.Manufactures.infrastructure.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Manufactures.application.ManufactureCreateService;
import com.airportagency.entities.Manufactures.application.ManufactureDeleteService;
import com.airportagency.entities.Manufactures.application.ManufactureGetAllService;
import com.airportagency.entities.Manufactures.application.ManufactureSearchService;
import com.airportagency.entities.Manufactures.application.ManufactureUpdateService;
import com.airportagency.entities.Manufactures.domain.entity.Manufactures;

public class ManufactureConsoleAdapter {
    Scanner scanner = new Scanner(System.in);

    private final ManufactureCreateService manufactureCreateService;
    private final ManufactureDeleteService manufactureDeleteService;
    private final ManufactureUpdateService manufactureUpdateService;
    private final ManufactureSearchService manufactureSearchService;
    private final ManufactureGetAllService manufactureGetAllService;

    

    public ManufactureConsoleAdapter(ManufactureCreateService manufactureCreateService,
            ManufactureDeleteService manufactureDeleteService, ManufactureUpdateService manufactureUpdateService,
            ManufactureSearchService manufactureSearchService, ManufactureGetAllService manufactureGetAllService) {
        this.manufactureCreateService = manufactureCreateService;
        this.manufactureDeleteService = manufactureDeleteService;
        this.manufactureUpdateService = manufactureUpdateService;
        this.manufactureSearchService = manufactureSearchService;
        this.manufactureGetAllService = manufactureGetAllService;
    }

    public void createManufacture(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("INGRESE EL ID DEL FABRICANTE");
            String newId =  scanner.nextLine();
            Optional<Manufactures> Manufacture = manufactureSearchService.getManufacturerById(newId);
            Manufacture.ifPresentOrElse(
                a -> {
                    System.out.println("FABRICANTE YA EXISTENTE");
                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    scanner.nextLine();
                },
                () -> {
                    System.out.println("INGRESE EL NOMBRE DEL FABRICANTE A CREAR");
                    String nameManufacture =  scanner.nextLine();
            
                    Manufactures newManufacture = new Manufactures(newId, nameManufacture);
                    manufactureCreateService.createManufacturer(newManufacture);
                }
            );
            System.out.println("DESEA REGISTRAR OTRO FABRICANTE? [S] SI | [CUALQUIER TECLA] NO");
            option = scanner.nextLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }

    public void searchManufacture(){
        List<Manufactures> allManufactures = manufactureGetAllService.getAllManufactures();
        if(allManufactures.isEmpty()){
            System.out.println("NO HAY FABRICANTES REGISTRADOS");
        }   else {
            System.out.println("INGRESE EL ID DE EL FABRICANTE A BUSCAR\n\n");
            String findId = scanner.nextLine();
            
            Optional<Manufactures> Manufacture = manufactureSearchService.getManufacturerById(findId);
            Manufacture.ifPresentOrElse(
                a -> System.out.println("ID: "+ a.getId() + "NOMBRE: " + a.getManufacturer()),
                () -> System.out.println("FABRICANTE NO ENCONTRADO")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void updateManufacture(){
        List<Manufactures> allManufactures = manufactureGetAllService.getAllManufactures();
        if(allManufactures.isEmpty()){
            System.out.println("NO HAY FABRICANTES REGISTRADOS");
        }   else {
            System.out.println("INGRESE EL ID DEL FABRICANTE A EDITAR\n\n");
            String findId = scanner.nextLine();

            Optional<Manufactures> Manufacture = manufactureSearchService.getManufacturerById(findId);
            Manufacture.ifPresentOrElse(
                a -> {
                    System.out.println("ID: "+ a.getId() + "NOMBRE: " + a.getManufacturer());

                    String updateId = a.getId();

                    System.out.println("[*]  INGRESE EL NUEVO NOMBRE DEL FABRICANTE");
                    String updateName = scanner.nextLine();

                    Manufactures updatedManufacture = new Manufactures(updateId, updateName);
                    manufactureUpdateService.updateManufacturer(updatedManufacture);
                },
                () -> System.out.println("[!]  AEROLINEA NO ENCONTRADA")
            );
        }
        System.out.println("[*]  PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void deleteManufacture(){
        List<Manufactures> allManufactures = manufactureGetAllService.getAllManufactures();
        if(allManufactures.isEmpty()){
            System.out.println("NO HAY FABRICANTES REGISTRADOS");
        }   else {
            System.out.println("INGRESE EL ID DEL FABRICANTE A ELIMINAR\n\n");
            String findId = scanner.nextLine();

            Optional<Manufactures> Manufacture = manufactureSearchService.getManufacturerById(findId);
            Manufacture.ifPresentOrElse(
                a -> {
                    manufactureDeleteService.deleteManufacturer(findId);
                },
                () -> System.out.println("FABRICANTE NO ENCONTRADO")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }

    public void getAllManufactures(){
        List<Manufactures> allManufactures = manufactureGetAllService.getAllManufactures();
        if(allManufactures.isEmpty()){
            System.out.println("NO HAY FABRICANTES REGISTRADOS");
        }   else {
            System.out.println("FABRICANTES REGISTRADOS");
            manufactureGetAllService.getAllManufactures().forEach(a -> {
                System.out.println("ID: "+ a.getId() + "NOMBRE: " + a.getManufacturer());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        scanner.nextLine();
    }
}
