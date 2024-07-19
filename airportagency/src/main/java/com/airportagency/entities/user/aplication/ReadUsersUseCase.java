package com.airportagency.entities.user.aplication;

import java.sql.SQLException;
import java.util.List;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class ReadUsersUseCase {

    private UserService userService;

    public ReadUsersUseCase(UserService userService) {
        this.userService = userService;
    }
    public List<User> execute() throws SQLException{
        return userService.readAllUser();

    }

}
