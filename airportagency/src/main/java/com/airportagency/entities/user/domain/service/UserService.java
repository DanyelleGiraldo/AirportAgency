package com.airportagency.entities.user.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.airportagency.entities.user.domain.entity.User;

public interface UserService {
    void createUser(User user) throws SQLException;
    User findUserById(Long id) throws SQLException;
    User updateById(Long id, String newName, String newPassword, int newRol)throws SQLException;
    User deleteById(Long id) throws SQLException;
    List<User> readAllUser()throws SQLException;
    boolean authUser(String name, String password) throws SQLException;
    String getUserRole(String username) throws SQLException;
}
