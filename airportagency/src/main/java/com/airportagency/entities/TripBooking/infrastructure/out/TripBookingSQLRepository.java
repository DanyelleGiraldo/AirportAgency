package com.airportagency.entities.TripBooking.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.FlightFares.domain.entity.FlightFares;
import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingSQLRepository implements TripBookingRepository {
    @Override
    public void save(TripBooking tripBooking) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(tripBooking.getBookingDate());
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tripBooking.getId());
                statement.setDate(2, sqlDate);
                statement.setString(3, tripBooking.getIdTrip());
                statement.setInt(4, tripBooking.getIdBookingStatus());
                statement.setString(5, tripBooking.getIdCustomer());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TripBooking tripBooking) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(tripBooking.getBookingDate());
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE trip_booking SET bookingDate = ?, idTrip = ?, idBookingStatus = ?, idCustomer = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, sqlDate);
                statement.setString(2, tripBooking.getIdTrip());
                statement.setInt(3, tripBooking.getIdBookingStatus());
                statement.setString(4, tripBooking.getIdCustomer());
                statement.setString(5, tripBooking.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TripBooking> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, bookingDate, idTrip, idBookingStatus, idCustomer FROM trip_booking WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        java.sql.Date sqlDate = resultSet.getDate("bookingDate");
                        LocalDate bookingDate = sqlDate.toLocalDate();
                        TripBooking tripBooking = new TripBooking(
                            resultSet.getString("id"),
                            bookingDate,
                            resultSet.getString("idTrip"),
                            resultSet.getInt("idBookingStatus"),
                            resultSet.getString("idCustomer")
                        );
                        return Optional.of(tripBooking);
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
            String query = "DELETE FROM trip_booking WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TripBooking> findAll() {
        List<TripBooking> tripBookings = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, bookingDate, idTrip, idBookingStatus, idCustomer FROM trip_booking";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    java.sql.Date sqlDate = resultSet.getDate("bookingDate");
                    LocalDate bookingDate = sqlDate.toLocalDate();
                    TripBooking tripBooking = new TripBooking(
                        resultSet.getString("id"),
                        bookingDate,
                        resultSet.getString("idTrip"),
                        resultSet.getInt("idBookingStatus"),
                        resultSet.getString("idCustomer")
                    );
                    tripBookings.add(tripBooking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripBookings;
    }

    
    @Override
    public Optional<FlightFares> findFlightFareByTripBId(String id) {
        Optional<FlightFares> flightFare = Optional.empty();
        String query = "SELECT ff.id, ff.description, ff.details, ff.value " +
                       "FROM trip_booking tb " +
                       "JOIN trip_booking_details tbd ON tb.id = tbd.idTripBooking " +
                       "JOIN flight_fares ff ON tbd.idFlightFares = ff.id " +
                       "WHERE tb.id = ?";
        
        try (Connection connection = DatabaseConfig.getConnection();

             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String flightFaresId = resultSet.getString("id");
                    String description = resultSet.getString("description");
                    String details = resultSet.getString("details");
                    double value = resultSet.getDouble("value");
                    
                    flightFare = Optional.of(new FlightFares(flightFaresId, description, details, value));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return flightFare;
    }

    @Override
    public List<String> findAllBookingTypes() {
        List<String> bookingTypes = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT bookingStatus FROM booking_status";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    bookingTypes.add(resultSet.getString("bookingStatus"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingTypes;
    }
    
    @Override
    public Optional<Integer> getBookingStatus(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT idBookingStatus FROM trip_booking WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);                
                try (ResultSet resultSet = statement.executeQuery()) {
                    int bookingStatus = resultSet.getInt("idBookingStatus");

                    return Optional.of(bookingStatus);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    @Override
    public void confirmBooking(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE trip_booking SET idBookingStatus = 2 WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelBooking(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE trip_booking SET idBookingStatus = 3 WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
