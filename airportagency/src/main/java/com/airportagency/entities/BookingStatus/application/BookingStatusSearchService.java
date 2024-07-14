package com.airportagency.entities.BookingStatus.application;

import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class BookingStatusSearchService {
    private final BookingStatusRepository bookingStatusRepository;

    public BookingStatusSearchService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    public Optional<BookingStatus> getBookingStatusById(int id){
        return bookingStatusRepository.findById(id);
    }
}
