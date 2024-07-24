package com.airportagency.entities.Plane.infrastructure.in;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.airportagency.entities.Manufactures.domain.entity.Manufactures;
import com.airportagency.entities.Plane.application.PlanesService;
import com.airportagency.entities.Plane.domain.entity.Plane;
import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.Status.domain.entity.Status;

public class PlaneConsoleAdapter {
    Scanner sc = new Scanner(System.in);

    private PlanesService planesService;
    
    

    public PlaneConsoleAdapter(PlanesService planesService) {
        this.planesService = planesService;
    }

    public void createPlanes(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("------REGISTRO DE AVION--------");
            System.out.println("\n[*]  INGRESE EL ID DEL AVION");
            String newId = sc.nextLine();

            Optional<Plane> plane = planesService.findById(newId);
            plane.ifPresentOrElse(
                g ->  {
                    System.out.println("[!]  AVION YA EXISTENTE");
                    System.out.println("[*]  PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                    sc.nextLine();
                },
                ()-> {
                    boolean isActive = true;
                    System.out.println("\n[*]  INGRESE LAS PLACAS DEL AVION");
                    String newPlates = sc.nextLine();

                    int newCapacity = 0;

                    while (isActive){
                        System.out.println("\n[*]  INGRESE LA CAPACIDAD DEL AVION (SOLO NUMEROS ENTEROS)");
                        try {
                            newCapacity = (Integer.parseInt(sc.nextLine()));
                            isActive = false;
                        }   catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese un número válido.\n Presione cualquier tecla para continuar...");
                            sc.nextLine();
                        }  
                        
                    }

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaCreacion = null;
                    boolean isActiveDate = false;
                    String newDate = "";

                    while (!isActiveDate) {
                        System.out.println("\n[*] INGRESE LA FECHA DE FABRICACION (dd-MM-yyyy)");
                        newDate = sc.nextLine();

                        try {
                            fechaCreacion = LocalDate.parse(newDate, formatter);
                            isActiveDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                        }
                    }

                    // MODELOS

                    boolean isActiveModels = true;
                    String newIdModel = "";

                    while (isActiveModels) {
                        List<PlaneModels> planeModels = planesService.findAllModels();
                        if(planeModels.isEmpty()){
                            System.out.println("NO HAY MODELOS REGISTRADOS\n\n| REGISTRE UN MODELO");
                            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                            sc.nextLine();
                            String optionModel = "S";

                            while(optionModel.equalsIgnoreCase("S")){
                                System.out.println("\nINGRESE EL ID DEL MODELO");
                                String findModelId = sc.nextLine();

                                Optional<PlaneModels> models = planesService.findByIdModel(findModelId);
                                models.ifPresentOrElse(
                                    
                                    g ->  {

                                        System.out.println("MODELO YA EXISTENTE");
                                        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                        sc.nextLine();
                                    },
                                    ()-> {

                                        System.out.println("\nINGRESE EL NOMBRE DEL MODELO");
                                        String newModel = sc.nextLine();

                                        
                                        List<Manufactures> manufactures = planesService.getAllManufactures();
                                        if(manufactures.isEmpty()){
                                            System.out.println("\n NO HAY FABRICANTES REGISTRADOS\n\n  | REGISTRE UN FABRICANTE");
                                            sc.nextLine();
                                            String optionManufacturer = "S";

                                            while(optionManufacturer.equalsIgnoreCase("S")){
                                                System.out.println("\n  INGRESE UN ID PARA EL FABRICANTE");
                                                String findManufacturerId = sc.nextLine();

                                                Optional<PlaneModels> manufacturer = planesService.findByIdModel(findManufacturerId);
                                                manufacturer.ifPresentOrElse(
                                                    g ->  {
                                                        System.out.println("FABRICANTE YA EXISTENTE");
                                                        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                                        sc.nextLine();
                                                    },
                                                    ()-> {
                                                        System.out.println("INGRESE EL NOMBRE DEL FABRICANTE A CREAR");
                                                        String nameManufacture =  sc.nextLine();
                                                
                                                        Manufactures newManufacture = new Manufactures(findManufacturerId, nameManufacture);
                                                        planesService.createManufacturer(newManufacture);
                                                    }
                                                );
                                                System.out.println("DESEA REGISTRAR OTRO FABRICANTE? [S] SI | [CUALQUIER TECLA] NO");
                                                optionManufacturer = sc.nextLine();   
                                            }  
                                            
                                        }
                                        System.out.println("\nFABRICANTES REGISTRADOS\n");            
                                        planesService.getAllManufactures().forEach(f -> {
                                            System.out.println("\nID: "+ f.getId() + "\n NOMBRE: " + f.getManufacturer());
                                        });
                                        System.out.println("\nINGRESE EL ID DEL FABRICANTE DEL MODELO");
                                        String newIdManufacturer = sc.nextLine();
                                        
                                        PlaneModels planes = new PlaneModels(findModelId, newModel, newIdManufacturer);
                                        planesService.createPlaneModels(planes);
                                    }
                                );
                                System.out.println("\nDESEA REGISTRAR OTRO MODELO? [S] SI | [CUALQUIER TECLA] NO");
                                optionModel = sc.nextLine();   
                            }  

                        } 
                        System.out.println("\nMODELOS REGISTRADOS\n");
                        planesService.findAllModels().forEach(f -> {
                            System.out.println("\nID DEL MODELO: "+ f.getId() + "\nMODELO: " + f.getModel() + "\nID DEL FABRICANTE: " + f.getIdManufacturer());
                        });
                        System.out.println("\nINGRESE EL ID DEL MODELO DEL AVION");
                        newIdModel = sc.nextLine();
                        isActiveModels = false;
                    }


                    boolean isActiveState = true;
                    String newIdStatus = "";
                    while (isActiveState) {
                        List<Status> statuses = planesService.getAllStatuses();
                        if(statuses.isEmpty()){
                            System.out.println("NO HAY ESTADOS REGISTRADOS\n\n[!] REGISTRE UN ESTADO");
                            System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                            sc.nextLine();
                            String optionStatus = "S";

                            while(optionStatus.equalsIgnoreCase("S")){
                                System.out.println("\nINGRESE EL ID DEL ESTADO");
                                String findStatusId = sc.nextLine();

                                Optional<Status> status = planesService.getStatusById(findStatusId);
                                status.ifPresentOrElse(
                                    g ->  {
                                        System.out.println("ESTADO YA EXISTENTE");
                                        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                        sc.nextLine();
                                    },
                                    ()-> {

                                        System.out.println("INGRESE EL NOMBRE DEL ESTADO: ");
                                        String statusName = sc.nextLine();
                        
                                        Status newStatus = new Status(findStatusId, statusName);
                                        planesService.createStatus(newStatus);
                                        System.out.println("ESTADO CREADO CORRECTAMENTE");
                                    }
                                );
                                System.out.println("DESEA REGISTRAR OTRO ESTADO? [S] SI | [CUALQUIER TECLA] NO");
                                optionStatus = sc.nextLine();   
                            }  

                        } 
                        System.out.println("\nESTADOS REGISTRADOS\n");
                        planesService.getAllStatuses().forEach(f -> {
                            System.out.println(MessageFormat.format("\nID : {0} \nESTADO : {1}", f.getId(), f.getStatus()));
                        });

                        System.out.println("\nINGRESE EL ID DEL ESTADO PARA EL AVION");
                        newIdStatus = sc.nextLine();
                        isActiveState = false;
                    }
                    
                    Plane planes = new Plane(newId, newPlates, newCapacity, fechaCreacion, newIdModel, newIdStatus);
                    planesService.createPlanes(planes);
                }
            );
            System.out.println("DESEA REGISTRAR OTRO AVION? [S] SI | [CUALQUIER TECLA] NO");
            option = sc.nextLine();   
        }  
    }

    public void searchPlane(){
        List<Plane> planesList = planesService.findAll();

        if(planesList.isEmpty()){
            System.out.println("NO HAY AVIONES REGISTRADOS");
        }else {
            System.out.println("AVION BUSCADO\n");
            System.out.println("INGRESE EL ID DEL AVION\n\n");
            String findId = sc.nextLine();

            Optional<Plane> planes = planesService.findById(findId);
            planes.ifPresentOrElse(
                f -> System.out.println("ID: "+ f.getId() + "\n PLACAS: " + f.getPlates() + "\n CAPACIDAD DEL AVION: " + f.getCapacity() + "\n FECHA DE FABRICACION: "+ f.getFabricationDate() + "\n  ID DEL MODELO" + f.getIdModel() + "\n  ID DEL ESTADO:" + f.getIdStatus()),
                () -> System.out.println("AVION NO ENCONTRADO")
            );
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void updatePlane(){
        List<Plane> planeList = planesService.findAll();

        if(planeList.isEmpty()){

            System.out.println("NO HAY AVIONES REGISTRADOS");

        }  else {

            System.out.println("INGRESE EL ID DEL AVION A EDITAR\n\n");
            String findId = sc.nextLine();

            Optional<Plane> model = planesService.findById(findId);
            model.ifPresentOrElse(
            f -> {
                System.out.println("ID: "+ f.getId() + "\n PLACAS: " + f.getPlates() + "\n CAPACIDAD DEL AVION: " + f.getCapacity() + "\n FECHA DE FABRICACION: "+ f.getFabricationDate() + "\n ID DEL MODELO" + f.getIdModel() + "\n  ID DEL ESTADO:" + f.getIdStatus());

                boolean isActive = true;
                System.out.println("\nINGRESE LAS PLACAS DEL AVION");
                String newPlates = sc.nextLine();

                int newCapacity = 0;

                while (isActive){
                    System.out.println("\nINGRESE LA CAPACIDAD DEL AVION (SOLO NUMEROS ENTEROS)");
                    try {
                        newCapacity = (Integer.parseInt(sc.nextLine()));
                        isActive = false;
                    }   catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un número válido.\n Presione cualquier tecla para continuar...");
                        sc.nextLine();
                    }  
                    
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaCreacion = null;
                boolean isActiveDate = false;
                String newDate = "";

                while (!isActiveDate) {
                    System.out.println("\n INGRESE LA FECHA DE FABRICACION (dd-MM-yyyy)");
                    newDate = sc.nextLine();

                    try {
                        fechaCreacion = LocalDate.parse(newDate, formatter);
                        isActiveDate = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Fecha ingresada no válida. Use el formato dd-MM-yyyy.");
                    }
                }


                boolean isActiveModels = true;
                String newIdModel = "";

                while (isActiveModels) {
                    List<PlaneModels> planeModels = planesService.findAllModels();
                    if(planeModels.isEmpty()){
                        System.out.println("NO HAY MODELOS REGISTRADOS\n\nREGISTRE UN MODELO");
                        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        String optionModel = "S";

                        while(optionModel.equalsIgnoreCase("S")){
                            System.out.println("\nINGRESE EL ID DEL MODELO");
                            String findModelId = sc.nextLine();

                            Optional<PlaneModels> models = planesService.findByIdModel(findModelId);
                            models.ifPresentOrElse(
                                
                                g ->  {

                                    System.out.println("MODELO YA EXISTENTE");
                                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                    sc.nextLine();
                                },
                                ()-> {

                                    System.out.println("\nINGRESE EL NOMBRE DEL MODELO");
                                    String newModel = sc.nextLine();

                                    
                                    List<Manufactures> manufactures = planesService.getAllManufactures();
                                    if(manufactures.isEmpty()){
                                        System.out.println("\nNO HAY FABRICANTES REGISTRADOS\n\nREGISTRE UN FABRICANTE");
                                        sc.nextLine();
                                        String optionManufacturer = "S";

                                        while(optionManufacturer.equalsIgnoreCase("S")){
                                            System.out.println("\n  INGRESE UN ID PARA EL FABRICANTE");
                                            String findManufacturerId = sc.nextLine();

                                            Optional<PlaneModels> manufacturer = planesService.findByIdModel(findManufacturerId);
                                            manufacturer.ifPresentOrElse(
                                                g ->  {
                                                    System.out.println("FABRICANTE YA EXISTENTE");
                                                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                                    sc.nextLine();
                                                },
                                                ()-> {
                                                    System.out.println("INGRESE EL NOMBRE DEL FABRICANTE A CREAR");
                                                    String nameManufacture =  sc.nextLine();
                                            
                                                    Manufactures newManufacture = new Manufactures(findManufacturerId, nameManufacture);
                                                    planesService.createManufacturer(newManufacture);
                                                }
                                            );
                                            System.out.println("DESEA REGISTRAR OTRO FABRICANTE? [S] SI | [CUALQUIER TECLA] NO");
                                            optionManufacturer = sc.nextLine();   
                                        }  
                                        
                                    }
                                    System.out.println("\nFABRICANTES REGISTRADOS\n");            
                                    planesService.getAllManufactures().forEach(q -> {
                                        System.out.println("\n ID: "+ q.getId() + "\n  NOMBRE: " + q.getManufacturer());
                                    });
                                    System.out.println("\nINGRESE EL ID DEL FABRICANTE DEL MODELO");
                                    String newIdManufacturer = sc.nextLine();
                                    
                                    PlaneModels planes = new PlaneModels(findModelId, newModel, newIdManufacturer);
                                    planesService.createPlaneModels(planes);
                                }
                            );
                            System.out.println("\nDESEA REGISTRAR OTRO MODELO? [S] SI | [CUALQUIER TECLA] NO");
                            optionModel = sc.nextLine();   
                        }  

                    } 
                    System.out.println("\n MODELOS REGISTRADOS\n");
                    planesService.findAllModels().forEach(a -> {
                        System.out.println("\nID DEL MODELO: "+ f.getId() + "\nMODELO: " + a.getModel() + "\nID DEL FABRICANTE: " + a.getIdManufacturer());
                    });
                    System.out.println("\nINGRESE EL ID DEL MODELO DEL AVION");
                    newIdModel = sc.nextLine();
                    isActiveModels = false;
                }

                boolean isActiveState = true;
                String newIdStatus = "";
                while (isActiveState) {
                    List<Status> statuses = planesService.getAllStatuses();
                    if(statuses.isEmpty()){
                        System.out.println("NO HAY ESTADOS REGISTRADOS\n\n[!] REGISTRE UN ESTADO");
                        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                        sc.nextLine();
                        String optionStatus = "S";

                        while(optionStatus.equalsIgnoreCase("S")){
                            System.out.println("\nINGRESE EL ID DEL ESTADO");
                            String findStatusId = sc.nextLine();

                            Optional<Status> status = planesService.getStatusById(findStatusId);
                            status.ifPresentOrElse(
                                g ->  {
                                    System.out.println("ESTADO YA EXISTENTE");
                                    System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
                                    sc.nextLine();
                                },
                                ()-> {

                                    System.out.println("INGRESE EL NOMBRE DEL ESTADO: ");
                                    String statusName = sc.nextLine();
                    
                                    Status newStatus = new Status(findStatusId, statusName);
                                    planesService.createStatus(newStatus);
                                    System.out.println("ESTADO CREADO CORRECTAMENTE");
                                }
                            );
                            System.out.println("DESEA REGISTRAR OTRO ESTADO? [S] SI | [CUALQUIER TECLA] NO");
                            optionStatus = sc.nextLine();   
                        }  

                    } 
                    System.out.println("\n|ESTADOS REGISTRADOS\n");
                    planesService.getAllStatuses().forEach(b -> {
                        System.out.println(MessageFormat.format("\nID : {0} \nESTADO : {1}", b.getId(), b.getStatus()));
                    });

                    System.out.println("\nINGRESE EL ID DEL ESTADO PARA EL AVION");
                    newIdStatus = sc.nextLine();
                    isActiveState = false;
                }

                      
                    Plane plane = new Plane(findId, newPlates, newCapacity, fechaCreacion, newIdModel, newIdStatus);
                    planesService.updatePlanes(plane);
            },
            () -> System.out.println("MODELO NO ENCONTRADO")
        );
        }
    }

    public void deletePlane(){
        List<Plane> models = planesService.findAll();
        if(models.isEmpty()){
            System.out.println("NO HAY MODELOS REGISTRADOS");
        }   else {
            getAllPlanes();
            System.out.println("\nINGRESE EL ID DEL AVION A ELIMINAR\n\n");
            String findId = sc.nextLine();

            Optional<Plane> planeModels = planesService.findById(findId);
            planeModels.ifPresentOrElse(
                f -> planesService.deletePlanes(findId),
                () -> System.out.println("AVION NO ENCONTRADO")
            );
        } 
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    }

    public void getAllPlanes(){
        List<Plane> plane = planesService.findAll();
        if(plane.isEmpty()){
            System.out.println("NO HAY AVIONES REGISTRADOS");
        } else {
            planesService.findAll().forEach(f -> {
                System.out.println("ID: "+ f.getId() + "\nPLACAS: " + f.getPlates() + "\n CAPACIDAD DEL AVION: " + f.getCapacity() + "\n FECHA DE FABRICACION: "+ f.getFabricationDate() + "\n  ID DEL MODELO" + f.getIdModel() + "\n  ID DEL ESTADO:" + f.getIdStatus());
            });
        }
        System.out.println("PRESIONE CUALQUIER TECLA PARA CONTINUAR...");
        sc.nextLine();
    } 
}
