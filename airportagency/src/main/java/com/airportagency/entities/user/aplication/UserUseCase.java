package com.airportagency.entities.user.aplication;

import java.sql.SQLException;
import com.airportagency.entities.user.domain.service.UserService;

public class UserUseCase {
    private final UserService userService;

    public UserUseCase(UserService userService) {
        this.userService = userService;
    }
    
    public String execute(String name) throws SQLException{
        return userService.getUserRole(name);
    }
}