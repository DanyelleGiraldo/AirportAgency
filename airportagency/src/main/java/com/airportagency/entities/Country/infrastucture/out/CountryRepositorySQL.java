package com.airportagency.entities.Country.infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airportagency.config.config.DatabaseConfig;
import com.airportagency.entities.Country.domain.entity.Country;
import com.airportagency.entities.Country.domain.service.CountryRepository;

public class CountryRepositorySQL implements CountryRepository {
    @Override
    public void save(Country country) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "INSERT INTO country (id, country) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, country.getId());
                statement.setString(2, country.getCountryName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country country) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "UPDATE country SET country = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, country.getCountryName());
                statement.setString(2, country.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Country> findById(String id) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, country FROM country WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    Country country = new Country(
                        resultSet.getString("id"),
                        resultSet.getString("country")
                    );
                    return Optional.of(country);
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
            String query = "DELETE FROM country WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection()) {
            String query = "SELECT id, country FROM country";
            try (PreparedStatement statement = connection.prepareStatement(query); 
                ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Country Country = new Country(
                            resultSet.getString("id"),
                            resultSet.getString("country")
                        );
                        countries.add(Country);
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
