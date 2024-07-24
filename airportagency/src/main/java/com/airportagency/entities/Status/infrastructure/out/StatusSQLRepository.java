package com.airportagency.entities.Status.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.Status.domain.entity.Status;
import com.airportagency.entities.Status.domain.service.StatusRepository;

public class StatusSQLRepository implements StatusRepository{
    
        @Override
        public void save(Status status){
        try (Connection connection = DatabaseConfig.getConnection()) {
                String query = "INSERT INTO plane_status (id, status) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setString(1, status.getId());
                    statement.setString(2, status.getStatus());
                    statement.executeUpdate();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
    
        }
    
        @Override
        public void update(Status status){
            try (Connection connection = DatabaseConfig.getConnection()) {
                String query = "UPDATE plane_status SET status = ? WHERE id = ?";
                try(PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setString(1, status.getStatus());
                    statement.setString(2, status.getId());
                    statement.executeUpdate();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    
        @Override 
        public Optional<Status> findById(String id){
            try (Connection connection = DatabaseConfig.getConnection()) {
                String query = "SELECT id, status FROM plane_status WHERE id = ?";
                try(PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setString(1, id);
                    try (ResultSet resultSet = statement.executeQuery()){
                        if(resultSet.next()){
                            Status status = new Status(
                                resultSet.getString("id"),
                                resultSet.getString("status")
                            );
                            return Optional.of(status);
                        }
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return Optional.empty();
        }
    
        @Override public void delete(String id){
            try (Connection connection = DatabaseConfig.getConnection()) {
                String query = "DELETE FROM plane_status WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)){
                    statement.setString(1, id);
                    statement.executeUpdate();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    
        @Override
        public List<Status> findAll(){
            List<Status> statuses = new ArrayList<>();
            try (Connection connection = DatabaseConfig.getConnection()) {
                String query = "SELECT id, status FROM plane_status";
                try (PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Status status = new Status(
                            resultSet.getString("id"),
                            resultSet.getString("status")
                        );
                        statuses.add(status);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return statuses;
        }
    }

