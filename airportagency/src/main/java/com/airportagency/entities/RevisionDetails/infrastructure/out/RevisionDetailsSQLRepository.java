package com.airportagency.entities.RevisionDetails.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.RevisionDetails.domain.entity.RevisionDetails;
import com.airportagency.entities.RevisionDetails.domain.service.RevisionDetailsRepository;

public class RevisionDetailsSQLRepository implements RevisionDetailsRepository {
    @Override
    public void save(RevisionDetails RevisionDetails){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO revision_details (id, Description, idEmployee) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, RevisionDetails.getId());
                statement.setString(2, RevisionDetails.getDescription());
                statement.setString(3, RevisionDetails.getIdEmployee());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(RevisionDetails RevisionDetails){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE revision_details SET description = ?, idEmployee = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, RevisionDetails.getDescription());
                statement.setString(2, RevisionDetails.getIdEmployee());
                statement.setString(3, RevisionDetails.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RevisionDetails> findById(String id){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM revision_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        RevisionDetails RevisionDetails = new RevisionDetails(
                            resultSet.getString("id"),
                            resultSet.getString("description"),
                            resultSet.getString("idEmployee")
                        );
                        return Optional.of(RevisionDetails);
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
            String query = "DELETE FROM revision_details WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<RevisionDetails> findAll(){
        List<RevisionDetails> RevisionDetails = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM revision_details";
            try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()){
                        RevisionDetails revisionDetails = new RevisionDetails(
                            resultSet.getString("id"),
                            resultSet.getString("description"),
                            resultSet.getString("idEmployee")
                        );
                        RevisionDetails.add(revisionDetails);
                    }
                }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return RevisionDetails;
    }
}
