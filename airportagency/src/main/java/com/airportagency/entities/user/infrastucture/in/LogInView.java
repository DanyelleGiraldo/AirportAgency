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
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("---------------------\n" +
        "       Sign in       \n" +
        "---------------------\n");

        System.out.print("\nEnter your username: ");
        String username = scanner.nextLine().trim();
        
        System.out.print("\nEnter your password: ");
        String password = scanner.nextLine().trim();

        try {
            controller.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during login: " + e.getMessage());
        }

        }

        
    }
}
