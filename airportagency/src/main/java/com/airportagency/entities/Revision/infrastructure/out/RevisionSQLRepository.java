package com.airportagency.entities.Revision.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.Revision.domain.entity.Revision;
import com.airportagency.entities.Revision.domain.service.RevisionRepository;

public class RevisionSQLRepository implements RevisionRepository {
    @Override
    public void save(Revision revision){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, revision.getId());
                statement.setDate(2, revision.getRevisionDate());
                statement.setString(3, revision.getIdPlane());
                statement.setString(4, revision.getIdDetails());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Revision revision){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE revision SET revisionDate = ?, idPlane = ?, idDetails = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setDate(1, revision.getRevisionDate());
                statement.setString(2, revision.getIdPlane());
                statement.setString(3, revision.getIdDetails());
                statement.setString(4, revision.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Revision> findById(String id){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT * FROM revision WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        Revision revision = new Revision(
                            resultSet.getString("id"),
                            resultSet.getDate("revisionDate"),
                            resultSet.getString("idPlane"),
                            resultSet.getString("idDetails")
                        );
                        return Optional.of(revision);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }  


    @Override public void delete(String id){
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "DELETE FROM revision WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Revision> findAll() {
        List<Revision> revisions = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, revisionDate, idPlane, idDetails FROM revision";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Revision revision = new Revision(
                        resultSet.getString("id"),
                        resultSet.getDate("revisionDate"),
                        resultSet.getString("idPlane"),
                        resultSet.getString("idDetails")
                    );
                    revisions.add(revision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revisions;
    }
}
