package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.Manufactures.infrastructure.out.ManufactureSQLRepository;
import com.airportagency.entities.Plane.application.PlanesService;
import com.airportagency.entities.Plane.infrastructure.in.PlaneConsoleAdapter;
import com.airportagency.entities.Plane.infrastructure.out.PlaneSQLRepository;
import com.airportagency.entities.PlaneModel.infrastructure.out.PlaneModelSQLRepository;
import com.airportagency.entities.Status.infrastructure.out.StatusSQLRepository;
public class AdminView {
    PlaneSQLRepository planesMySQLRepository = new PlaneSQLRepository();
    PlaneModelSQLRepository planeModelSQLRepository = new PlaneModelSQLRepository();
    StatusSQLRepository statusSQLRepository = new StatusSQLRepository();
    ManufactureSQLRepository manufactureSQLRepository = new ManufactureSQLRepository();

    public void start(){
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("1. Gestion de Aviones");
                System.out.println("2. Gestion de Vuelos");
                System.out.println("3. Gestion de Aeropuertos");
                System.out.println("4. Gestion de Documentos ");
                System.out.println("5. Conexiones de Vuelos");
                System.out.println("6. Tarifas de Vuelo");
                System.out.println("7. Salir");
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        System.out.println("1. Register plane");
                        System.out.println("2. View plane information");
                        System.out.println("3. Update plane information");
                        System.out.println("4. Delete plane");
                        System.out.println("5. Salir");

                        int op= scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planesConsoleController = new PlaneConsoleAdapter(planesService);
                                planesConsoleController.createPlanes();
                            }
                            case 2 -> {
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.searchPlane();
                            }
                            case 3 ->{
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.updatePlane();
                            }
                            case 4 ->{
                                PlanesService planesService = new PlanesService(planesMySQLRepository, planeModelSQLRepository, statusSQLRepository, manufactureSQLRepository);
                                PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planesService);
                                planeConsoleAdapter.deletePlane();
                            }
                            case 5 ->{
                                start();
                            }
                        }           
                    }
                    case 2 ->{
                        System.out.println("1.Asignar tripulación de vuelo");
                        System.out.println("2.Ver información del vuelo");
                        System.out.println("3.Asignar avión al vuelo");
                        System.out.println("4.Actualizar información del vuelo");
                        System.out.println("5.Eliminar vuelo");
                        System.out.println("6.Ver asignación de tripulación");
                        System.out.println("7.Ver conexiones de vuelo");
                        System.out.println("8.Actualizar información de conexión de vuelo");
                        System.out.println("9.Eliminar conexión de vuelo");
                        System.out.println("10.Registrar tarifa de vuelo");
                        System.out.println("11.Actualizar información de tarifa de vuelo");
                        System.out.println("12.Eliminar tarifa de vuelo");
                        System.out.println("13.Ver tarifa de vuelo");

                        int op = scanner.nextInt();
                        scanner.nextLine();

                        switch (op) {
                            case 1 ->{

                            }
                            
                        }
                    }
                    case 3->{
                        
                    }
                    
                    case 7 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                        }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 7.");
                }
            }
        }
    }
}
