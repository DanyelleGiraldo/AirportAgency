package com.airportagency.entities.user.aplication;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class CreateUserUseCase {

private final UserService userService;

public CreateUserUseCase(UserService userService){
    this.userService = userService;
}

public void execute(User user) throws SQLException{
    userService.createUser(user);
}
}

