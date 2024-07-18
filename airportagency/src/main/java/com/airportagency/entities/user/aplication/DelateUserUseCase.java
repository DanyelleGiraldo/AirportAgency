package com.airportagency.entities.user.aplication;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class DelateUserUseCase {
private UserService userService;

public DelateUserUseCase(UserService userService) {
    this.userService = userService;
}
public User execute(Long id) throws SQLException {
        return userService.deleteById(id);
    }

}

