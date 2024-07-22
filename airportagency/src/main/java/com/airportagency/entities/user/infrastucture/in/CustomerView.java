package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

public class CustomerView {
    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Search flight");
                System.out.println("2. Select flight");
                System.out.println("3. Add passengers");
                System.out.println("4. Select seats");
                System.out.println("5. Realize payment");
                System.out.println("6. View flight booking");
                System.out.println("7. Cancel flight booking");
                System.out.println("8. Update flight booking");
                System.out.println("9. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> System.out.println("1");
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> System.out.println("4");
                    case 5 -> System.out.println("5");
                    case 6 -> System.out.println("6");
                    case 7 -> System.out.println("7");
                    case 8 -> System.out.println("8");
                    case 9 -> salir = true;
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 9.");
                }
            }
        }
    }
}
