package com.airportagency.entities.user.aplication;

import java.util.List;

import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class UserUseCase {
    private final UserService userService;

    public UserUseCase(UserService userService) {
        this.userService = userService;
    }
    
    public List<String> getPermisosCase(int id_rolUsuario){
        return userService.getPermisos(id_rolUsuario);
    }
}