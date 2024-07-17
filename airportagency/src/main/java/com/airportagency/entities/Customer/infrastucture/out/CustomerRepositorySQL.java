package com.airportagency.entities.Customer.infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.Customer.domain.entity.Customer;
import com.airportagency.entities.Customer.domain.service.CustomerRepository;

public class CustomerRepositorySQL implements CustomerRepository{


    @Override
    public void save(Customer customer){
        try(Connection connection = DatabaseConfig.getConnection()){

            String query = "INSERT INTO customer (id,name,lastname,age,documentNumber,idDocumentType) VALUES(?,?,?,?,?,?)";

            try(PreparedStatement statement = connection.prepareStatement(query)){

                statement.setString(1, customer.getId());
                statement.setString(2, customer.getName());
                statement.setString(3, customer.getLastName());
                statement.setInt(4, customer.getAge());
                statement.setInt(5, customer.getDocumentNumber());
                statement.setInt(6, customer.getIdDocumentType());
                statement.executeUpdate();

            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = DatabaseConfig.getConnection()){

            String query = "UPDATE customer SET name = ?, lastName = ?, age = ?, documentNumber = ?, idDocumentType= ? WHERE id = ?";

            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, customer.getName());
                statement.setString(2, customer.getLastName());
                statement.setInt(3, customer.getAge());
                statement.setInt(4, customer.getDocumentNumber());
                statement.setInt(5, customer.getIdDocumentType());
                statement.setString(6, customer.getId());
                statement.executeUpdate();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()){
            String query = "SELECT id,name,lastName,age,documentNumber,idDocumentType FROM customer WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                try(ResultSet resultSet = statement.executeQuery()){
                    Customer customer = new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getInt("documentNumber"),
                        resultSet.getInt("idDocumentType")  
                    );
                    return Optional.of(customer);
                }  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        try (Connection connection = DatabaseConfig.getConnection()){
            String query = "DELETE FROM customer WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, id);
                statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DatabaseConfig.getConnection()){
            String query = "SELECT id,name,lastName,age,documentNumber,idDocumentType FROM customer";
            try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        Customer customer = new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        resultSet.getInt("documentNumber"),
                        resultSet.getInt("idDocumentType") 
                        );
                        customers.add(customer);
                    }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
}
