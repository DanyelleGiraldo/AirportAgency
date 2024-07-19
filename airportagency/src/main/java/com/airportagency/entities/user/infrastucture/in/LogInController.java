package com.airportagency.entities.user.infrastucture.in;

import com.airportagency.entities.user.domain.service.UserService;

import java.sql.SQLException;

import com.airportagency.entities.user.infrastucture.out.UserRepository;

public class LogInController {

    private final UserService userService;

    public LogInController(UserService userR) {
        this.userService = userR;
    }

    public boolean login(String name, String password) throws SQLException {
        final String userRole;
        

        if (userService.authUser(name, password)) {
            UserRepository userRep = new UserRepository();
            userRole = userRep.getUserRole(name);
            switch (userRole) {
                case "admin":
                    System.out.println("Admin");
                    break;
                case "tecnico":
                    System.out.println("Tecnico");
                    break;
                case "customer":
                    System.out.println("cliente");
                    break;
                case "sells":
                    System.out.println("Ventas");
                    break;
                default:
                    throw new IllegalStateException("Unexpected role: " + userRole);
            }
            return true;
        } else {
            return false;
        }
    }

}

