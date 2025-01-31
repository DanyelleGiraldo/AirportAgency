package com.airportagency.entities.user.aplication;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class FindUserUseCase {

    private final UserService userService;

    public FindUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public User execute(Long id) throws SQLException {
        return userService.findUserById(id);
    }
}
