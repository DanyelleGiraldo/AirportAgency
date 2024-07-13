package com.airportagency.entities.airport.infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.airport.domain.entity.Airport;
import com.airportagency.entities.airport.domain.service.Airportrepository;

public class AirportRepositorySQL implements Airportrepository {

    @Override
    public void save(Airport airport) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO airport (id, airport, idCity) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airport.getId());
                statement.setString(2, airport.getAirport());
                statement.setString(3, airport.getIdCity());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE airport SET airport = ?, idCity = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airport.getAirport());
                statement.setString(2, airport.getIdCity());
                statement.setString(3, airport.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Airport> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, airport, idCity FROM airport WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Airport airport = new Airport(
                            resultSet.getString("id"),
                            resultSet.getString("airport"),
                            resultSet.getString("idCity")
                        );
                        return Optional.of(airport);
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
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "DELETE FROM airport WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, airport, idCity FROM airport";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Airport airport = new Airport(
                            resultSet.getString("id"),
                            resultSet.getString("airport"),
                            resultSet.getString("idCity")
                        );
                        airports.add(airport);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }
}
