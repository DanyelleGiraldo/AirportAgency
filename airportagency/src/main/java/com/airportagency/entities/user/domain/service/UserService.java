package com.airportagency.entities.user.domain.service;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;

public interface UserService {
    void createUser(User user) throws SQLException;
    User findUserById(Long id);
    User updateById(Long id, String newName, String newPasswordn);
    User deleteById(Long id);
    User listUserbyName(String name);
    boolean authUser(User user) throws SQLException;
    String getUserRole(String username) throws SQLException;
}
