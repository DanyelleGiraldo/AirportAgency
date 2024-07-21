package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

public class TechnicalView {
    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Register revision");
                System.out.println("2. View plane revision history");
                System.out.println("3. Update revision information");
                System.out.println("4. Delete maintenance revision");
                System.out.println("5. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> System.out.println("1");
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> System.out.println("4");
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 5.");
                }
            }
        }
    }
}
