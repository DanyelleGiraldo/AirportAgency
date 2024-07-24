package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

public class AdminView {

    public void start(){
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("1. Gestion de Aviones");
                System.out.println("2. Gestion de Tripulacion");
                System.out.println("3. Gestion de Vuelos");
                System.out.println("4. Gestion de Aeropuertos");
                System.out.println("7. Gestion de Documentos ");
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
                            case 1 -> ;

                        }
                                break;
                        
                            default:
                                break;
                        }
                    }
                    case 2 -> System.out.println("View plane information selected.");
                    case 3 -> System.out.println("Assign flight crew selected.");
                    case 4 -> System.out.println("View flight information selected.");
                    case 5 -> System.out.println("Create Airport selected.");
                    case 6 -> System.out.println("View Airport information selected.");
                    case 7 -> System.out.println("Update plane information selected.");
                    case 8 -> System.out.println("Delete plane selected.");
                    case 9 -> System.out.println("Assign flight plane selected.");
                    case 10 -> System.out.println("Update flight information selected.");
                    case 11 -> System.out.println("Delete flight selected.");
                    case 12 -> System.out.println("Update airport information selected.");
                    case 13 -> System.out.println("Delete airport selected.");
                    case 14 -> System.out.println("View flight information selected.");
                    case 15 -> System.out.println("View crew assignment selected.");
                    case 16 -> System.out.println("View flight connections selected.");
                    case 17 -> System.out.println("Update flight connection information selected.");
                    case 18 -> System.out.println("Delete flight connection selected.");
                    case 19 -> System.out.println("Register flight fare selected.");
                    case 20 -> System.out.println("Update flight fare information selected.");
                    case 21 -> System.out.println("Delete flight fare selected.");
                    case 22 -> System.out.println("View flight fare selected.");
                    case 23 -> System.out.println("Register type of document selected.");
                    case 24 -> System.out.println("Update type of document selected.");
                    case 25 -> System.out.println("Delete type of document selected.");
                    case 26 -> System.out.println("View types of document selected.");
                    case 27 -> {
                        salir = true;
                        MainView mainView = new MainView();
                        mainView.start();
                        }
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 27.");
                }
            }
        }
    }
}
