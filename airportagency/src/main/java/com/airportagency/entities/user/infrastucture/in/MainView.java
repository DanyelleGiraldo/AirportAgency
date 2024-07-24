package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

public class MainView {
    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Ingresar ");
                System.out.println("2. Acceder Como Cliente");
                System.out.println("3. Salir");
                
                int option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option) {
                    case 1 -> {
                        LogInView login = new LogInView();
                        login.start();
                    }
                    case 2 -> {
                        System.out.println("Has elegido la opción 2") ;
                        
                    }
                    case 3 ->{
                        salir = true;
                    } 
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 4");
                }
            }
        }
    }
}
