package com.airportagency.entities.user.infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.user.domain.entity.User;
import com.airportagency.entities.user.domain.service.UserService;

public class UserRepository implements UserService {

    public static final String UserUseCase = null;

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO user(name, password1) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getNombre_usuario());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId_usuario(generatedKeys.getLong(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(Long id) {
       String sql = "select id, name, email from user where id = ?";
       User user = null;
       try(Connection connection = DatabaseConfig.getConnection();PreparedStatement statement = connection.prepareStatement(sql)){
        statement.setLong(1, id);
        try(ResultSet resultSet = statement.executeQuery()){
            if (resultSet.next()) {
                user = new User();
                user.setId_usuario(resultSet.getLong("id"));
                user.setNombre_usuario(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        
       } catch (SQLException e) {
        
        e.printStackTrace();
    }
    return user;
       
    }

    @Override
    public User updateById(Long id, String newName, String newPassword, int rol_id) {
        String sql = "UPDATE user SET name = ?, password = ?, rol_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setString(2, newPassword);
            statement.setInt(3, rol_id);
            statement.setLong(4, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return findUserById(id); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User deleteById(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Usuario con ID " + id + " eliminado correctamente.");
          
            } else {
                System.out.println("No se encontró ningún usuario con ID " + id + " para eliminar.");
            }
    
        } catch (SQLException e) {
            System.out.println("error try : " + e);
    
        }
        
        return null;
    }


    @Override
    public boolean authUser(String name, String password) throws SQLException {
        String sql = "SELECT password FROM user WHERE name = ?";
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, name);
                
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    return storedPassword.equals(password);
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("Error al ejecutar la consulta", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al autenticar el usuario", e);
        }
    }

    @Override
    public String getUserRole(String name) throws SQLException {
    String roleName = null;

    String sql = "SELECT r.name " +
                 "FROM user u " +
                 "JOIN rol r ON u.rol_id = r.id " +
                 "WHERE u.name = ?";

    try (Connection connection = DatabaseConfig.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, name);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                roleName = rs.getString("name");
            }
        }

    }catch (SQLException e) {
        e.printStackTrace();
        throw new SQLException("Error al obtener el rol del usuario", e);
    }

    return roleName;
    }

    @Override
    public List<User> readAllUser() {
        List<User> users = new ArrayList<>();
        try(Connection connection = DatabaseConfig.getConnection()){
            String sql = "SELECT * FROM user";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getInt("rol_id")
                        );
                        users.add(user);
                    }
                    
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

}