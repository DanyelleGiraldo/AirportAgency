package com.airportagency;

import java.util.Scanner;

import com.airportagency.entities.auth.infrastructure.in.LogInView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Elige una opción: ");
            System.out.println("1. Ingresar ");
            System.out.println("2. Acceder Como Cliente");
            System.out.println("3. Salir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    LogInView login = new LogInView();
                    login.start();
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2");
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción entre 1 y 4");
                    break;
            }
        }

        scanner.close();
    }
}