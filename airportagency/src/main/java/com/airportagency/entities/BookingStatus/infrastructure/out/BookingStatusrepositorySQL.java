package com.airportagency.entities.BookingStatus.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class BookingStatusrepositorySQL implements BookingStatusRepository {
    @Override
    public void save(BookingStatus bookingStatus){
        try (Connection connection = DatabaseConfig.getConnection();){
            String query = "INSERT INTO booking_status(id,bookingStatus) VALUES(?,?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, bookingStatus.getId());
                statement.setString(2, bookingStatus.getBookingStatus());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override 
    public Optional<BookingStatus> findById(int id){
        try (Connection connection = DatabaseConfig.getConnection();){
            String query = "SELECT * FROM booking_status where id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);
                 try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        BookingStatus bookingStatus = new BookingStatus(
                            resultSet.getInt("id"),
                            resultSet.getString("bookingStatus")
                        );
                        return Optional.of(bookingStatus);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty(); 
    }

    @Override
    public List<BookingStatus> findAll(){
        List<BookingStatus> bookingStatuz = new ArrayList<>();
        try(Connection connection = DatabaseConfig.getConnection();){
            String query = "SELECT * FROM booking_status";
            try(PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    BookingStatus bookingStatus = new BookingStatus(
                        resultSet.getInt("id"),
                        resultSet.getString("bookingStatus")
                    );
                    bookingStatuz.add(bookingStatus);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bookingStatuz;
    } 
}
