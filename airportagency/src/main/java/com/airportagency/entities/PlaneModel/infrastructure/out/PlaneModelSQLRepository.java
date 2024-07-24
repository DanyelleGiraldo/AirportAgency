package com.airportagency.entities.PlaneModel.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.PlaneModel.domain.entity.PlaneModels;
import com.airportagency.entities.PlaneModel.domain.service.PlaneModelRepository;

public class PlaneModelSQLRepository implements PlaneModelRepository {
    @Override
    public void save(PlaneModels planeModels){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO model (id, model, idManufacturer) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, planeModels.getId());
                statement.setString(2, planeModels.getModel());
                statement.setString(3, planeModels.getIdManufacturer());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(PlaneModels planeModels){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE model SET model = ?, idManufacturer = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, planeModels.getModel());
                statement.setString(2, planeModels.getIdManufacturer());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PlaneModels> findById(String id){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM model WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        PlaneModels PlaneModels = new PlaneModels(
                            resultSet.getString("id"),
                            resultSet.getString("manufacturer"),
                            resultSet.getString("idManufacturer")
                        );
                        return Optional.of(PlaneModels);
                    }

                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override 
    public void delete(String id){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "DELETE FROM model WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<PlaneModels> findAll(){
        List<PlaneModels> PlaneModels = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM model";
            try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()){
                        PlaneModels planeModel = new PlaneModels(
                            resultSet.getString("id"),
                            resultSet.getString("model"),
                            resultSet.getString("idManufacturer")
                        );
                        PlaneModels.add(planeModel);
                    }
                }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return PlaneModels;
    }
}
