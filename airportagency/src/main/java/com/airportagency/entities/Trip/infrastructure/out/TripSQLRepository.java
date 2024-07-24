package com.airportagency.entities.Trip.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.Trip.domain.entity.Trip;
import com.airportagency.entities.Trip.domain.service.TripRepository;

public class TripSQLRepository implements TripRepository{
    @Override
    public void save(Trip trip){
        java.sql.Date sqlDate = java.sql.Date.valueOf(trip.getTripDate());
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO trip (id, tripDate, price) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, trip.getId());
                statement.setDate(2, sqlDate);
                statement.setDouble(3, trip.getPrice());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Trip trip) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(trip.getTripDate());
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE trip SET tripDate = ?, price = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, sqlDate);
                statement.setDouble(2, trip.getPrice());
                statement.setString(3, trip.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Optional<Trip> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, tripDate, price FROM trip WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        java.sql.Date sqlDate = resultSet.getDate("tripDate");
                        LocalDate tripDate = sqlDate.toLocalDate();
                        Trip trip = new Trip(
                            resultSet.getString("id"),
                            tripDate, 
                            resultSet.getInt("price")
                        );
                        return Optional.of(trip);
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
            String query = "DELETE FROM trip WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Trip> findAll(){
        List<Trip> trips = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, tripDate, price FROM trip";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    java.sql.Date sqlDate = resultSet.getDate("tripDate");
                    LocalDate tripDate = sqlDate.toLocalDate();
                    Trip trip = new Trip(
                        resultSet.getString("id"),
                        tripDate, 
                        resultSet.getInt("price")
                    );
                    trips.add(trip);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }

    @Override
    public Optional<List<Trip>> findByParameters(LocalDate tripDate, String idCityA, String idCityB) {
        List<Trip> matchTrips = new ArrayList<>();
        String query = "SELECT t.id, t.tripDate, t.price " +
                       "FROM flight_connection fc " +
                       "JOIN trip t ON fc.idTrip = t.id " +
                       "JOIN airport a ON fc.idAirportA = a.id " +
                       "JOIN airport ab ON fc.idAirportB = ab.id " +
                       "JOIN city c ON a.idCity = c.id " +
                       "JOIN city cb ON ab.idCity = cb.id " +
                       "WHERE t.tripDate = ? AND c.id = ? AND cb.id = ?";
        try (Connection connection = DatabaseConfig.getConnection();

             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setDate(1, java.sql.Date.valueOf(tripDate));
            statement.setString(2, idCityA);
            statement.setString(3, idCityB);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    java.sql.Date sqlDate = resultSet.getDate("tripDate");
                    LocalDate newTripDate = sqlDate.toLocalDate();
                    Trip trip = new Trip(
                        resultSet.getString("id"),
                        newTripDate,
                        resultSet.getDouble("price")
                    );
                    matchTrips.add(trip);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchTrips.isEmpty() ? Optional.empty() : Optional.of(matchTrips);
    }
}
