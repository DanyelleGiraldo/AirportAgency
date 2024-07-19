package com.airportagency.entities.FlightConnection.infrastructure.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.FlightConnection.domain.entity.FlightConnection;
import com.airportagency.entities.FlightConnection.domain.service.FlightConnectionRepository;



public class FlightConnectionMySQLRepository implements FlightConnectionRepository {

    @Override
    public void save(FlightConnection flightConnection) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightConnection.getId());
                statement.setInt(2, flightConnection.getConnectionOrder());
                statement.setString(3, flightConnection.getIdTrip());
                statement.setString(4, flightConnection.getIdPlane());
                statement.setString(5, flightConnection.getIdAirportA());
                statement.setString(6, flightConnection.getIdArportB());
                statement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FlightConnection flightConnection) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE flight_connection SET id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightConnection.getId());
                statement.setInt(2, flightConnection.getConnectionOrder());
                statement.setString(3, flightConnection.getIdTrip());
                statement.setString(4, flightConnection.getIdPlane());
                statement.setString(5, flightConnection.getIdAirportA());
                statement.setString(6, flightConnection.getIdArportB());
                statement.executeUpdate();
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FlightConnection> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB  FROM flight_connection WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FlightConnection flightConnection = new FlightConnection(
                            resultSet.getString("id"),
                            resultSet.getInt("connectionOrder"),
                            resultSet.getString("idTrip"),
                            resultSet.getString("idPlane"),
                            resultSet.getString("idAirportA"),
                            resultSet.getString("idAirportB")
                        );
                        return Optional.of(flightConnection);
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
            try (Statement disableFK = connection.createStatement()) {
                disableFK.execute("SET FOREIGN_KEY_CHECKS = 0");
            }

            String query = "DELETE FROM flight_connection WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }

            try (Statement enableFK = connection.createStatement()) {
                enableFK.execute("SET FOREIGN_KEY_CHECKS = 1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<FlightConnection> findAll() {
        List<FlightConnection> flightConnections = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB FROM flight_connection";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    FlightConnection flightConnection = new FlightConnection(
                        resultSet.getString("id"),
                        resultSet.getInt("connectionOrder"),
                        resultSet.getString("idTrip"),
                        resultSet.getString("idPlane"),
                        resultSet.getString("idAirportA"),
                        resultSet.getString("idAirportB")
                    );
                    flightConnections.add(flightConnection);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightConnections;
    }

    @Override
    public Optional<FlightConnection> findByTrip(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB FROM flight_connection WHERE idTrip = ?  ORDER BY connectionOrder";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FlightConnection flightConnection = new FlightConnection(
                            resultSet.getString("id"),
                            resultSet.getInt("connectionOrder"),
                            resultSet.getString("idTrip"),
                            resultSet.getString("idPlane"),
                            resultSet.getString("idAirportA"),
                            resultSet.getString("idAirportB")
                        );
                        return Optional.of(flightConnection);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    

}
