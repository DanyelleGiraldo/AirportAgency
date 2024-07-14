package com.airportagency.entities.BookingStatus.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;

public interface BookingStatusRepository {
    void save(BookingStatus bookingStatus);
    Optional<BookingStatus> findById(int id);
    List<BookingStatus> findAll();
}
