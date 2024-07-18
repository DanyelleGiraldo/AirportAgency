package com.airportagency.entities.user.aplication;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class UpdateUserUseCase {

    private final UserService userService;

    public UpdateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public User execute(Long id, String newName, String newPassword, int newRol) throws SQLException {
        return userService.updateById(id, newName, newPassword, newRol);
    }
}