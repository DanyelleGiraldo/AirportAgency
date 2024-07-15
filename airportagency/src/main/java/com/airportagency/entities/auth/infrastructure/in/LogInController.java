package com.airportagency.entities.auth.infrastructure.in;

import com.airportagency.entities.user.domain.service.UserService;

import java.sql.SQLException;

import com.airportagency.entities.user.infrastucture.out.UserRepository;
import com.airportagency.entities.user.domain.entity.User;

public class LogInController {

    private final UserService userService;

    public LogInController(UserService userR) {
        this.userService = userR;
    }

    public boolean login(String username, String password) throws SQLException {
        final String userRole;
        User user = new User();
        user.setNombre_usuario(username);
        user.setPassword(password);
        

        if (userService.authUser(user)) {
            UserRepository userRep = new UserRepository();
            userRole = userRep.getUserRole(username);
            switch (userRole) {
                case "Super Admin":
                    System.out.println("Super Admin");
                    break;
                case "Administrator":
                    System.out.println("Admin");
                    break;
                case "Maintenance Technician":
                    System.out.println("Tecnico");
                    break;
                case "Sales Agent":
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

