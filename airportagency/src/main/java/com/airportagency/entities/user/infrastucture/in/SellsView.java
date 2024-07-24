package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

public class SellsView {
    public void start(){
        try(Scanner scanner = new Scanner(System.in)){
            boolean salir = false;

            while (!salir) {
                System.out.println("Elige una opción: ");
                System.out.println("1. Create booking");
                System.out.println("2. View customer information");
                System.out.println("3. View flights bookings");
                System.out.println("4. Create customer");
                System.out.println("5. Update customer info");
                System.out.println("6. Delete flight booking");
                System.out.println("7. View flight information");
                System.out.println("8. View flight connections");
                System.out.println("9. View flight fare");
                System.out.println("10. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {

                    }
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");
                    case 4 -> System.out.println("4");
                    case 5 -> System.out.println("5");
                    case 6 -> System.out.println("6");
                    case 7 -> System.out.println("7");
                    case 8 -> System.out.println("8");
                    case 9 -> System.out.println("9");
                    case 10 -> salir = true;
                    default -> System.out.println("Opción no válida, por favor elige una opción entre 1 y 10.");
                }
            }
        }
    }
}
