package com.airportagency.entities.user.domain.service;

import java.sql.SQLException;

import com.airportagency.entities.user.domain.entity.User;

public interface UserService {
    void createUser(User user) throws SQLException;
    User findUserById(Long id) throws SQLException;
    User updateById(Long id, String newName, String newPassword, int newRol)throws SQLException;
    User deleteById(Long id) throws SQLException;
    User listUserName(String name)throws SQLException;
    boolean authUser(User user) throws SQLException;
    String getUserRole(String username) throws SQLException;
}
