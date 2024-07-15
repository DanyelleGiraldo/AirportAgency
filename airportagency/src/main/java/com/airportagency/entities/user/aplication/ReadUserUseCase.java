package com.airportagency.entities.user.aplication;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class ReadUserUseCase {

    private UserService userService;

    public ReadUserUseCase(UserService userService) {
        this.userService = userService;
    }
    public User execute(String name){

         return userService.listUserbyName(name);
    }


}
