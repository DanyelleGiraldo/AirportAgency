package com.airportagency.entities.tripbookindetails.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.tripbookindetails.domain.entity.TripBookingDetails;

public interface TripBookingDetailsRepository {
    void save(TripBookingDetails tripBookingDetail);
    void update(TripBookingDetails tripBookingDetails);
    Optional<TripBookingDetails> findById(String id);
    void delete(String id);
    List<TripBookingDetails> findAll();

}
