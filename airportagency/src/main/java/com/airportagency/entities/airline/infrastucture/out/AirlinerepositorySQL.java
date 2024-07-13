package com.airportagency.entities.airline.infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.airline.domain.entity.Airline;
import com.airportagency.entities.airline.domain.service.AirlinesRepository;

public class AirlinerepositorySQL implements AirlinesRepository {
    @Override
    public void save(Airline airline) {
        try (Connection connection = DatabaseConfig.getConnection();) {
            String query = "INSERT INTO airline (id, airline) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airline.getName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airline airline) {
        try (Connection connection = DatabaseConfig.getConnection();) {
            String query = "UPDATE airline SET aerolinea = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airline.getName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Airline> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection();) {
            String query = "SELECT * FROM airline WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Airline airline = new Airline(
                            resultSet.getString("id"),
                            resultSet.getString("nombre")
                        );
                        return Optional.of(airline);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        try (Connection connection = DatabaseConfig.getConnection();) {
            String query = "DELETE FROM airline WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airline> findAll() {
        List<Airline> airlines = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();) {
            String query = "SELECT * FROM airline";
            try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Airline airline = new Airline(
                        resultSet.getString("id"),
                        resultSet.getString("nombre")
                    );
                    airlines.add(airline);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airlines;
    }
}
