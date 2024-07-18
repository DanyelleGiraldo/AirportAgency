package com.airportagency.entities.user.infrastucture.in;

import java.util.Scanner;

import com.airportagency.entities.user.domain.service.UserService;
import com.airportagency.entities.user.infrastucture.out.UserRepository;

public class LogInView {
    
    private final LogInController controller;

    public LogInView() {
        UserService userRep = new UserRepository();
        this.controller = new LogInController(userRep); 
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------\n" +
        "       Sign in       \n" +
        "---------------------\n");

        System.out.print("\nEnter your username: ");
        String username = sc.nextLine().trim();
        System.out.print("\nEnter your password: ");
        String password = sc.nextLine().trim();
        System.out.println();

        try {
            boolean success = controller.login(username, password);
            if (success) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during login: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
