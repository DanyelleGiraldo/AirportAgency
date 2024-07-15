package com.airportagency.entities.user.aplication;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class DelateUserUseCase {
private UserService userService;

public DelateUserUseCase(UserService userService) {
    this.userService = userService;
}
public User execute(Long id) {
        return userService.deleteById(id);
    }

}

