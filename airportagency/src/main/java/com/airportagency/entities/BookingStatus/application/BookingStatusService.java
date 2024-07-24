package com.airportagency.entities.BookingStatus.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class BookingStatusService {
    private final BookingStatusRepository bookingStatusRepository;

    public BookingStatusService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    public void createBookingStatus(BookingStatus bookingStatus) {
        bookingStatusRepository.save(bookingStatus);
    }

    public Optional<BookingStatus> getBookingStatusById(int id) {
        return bookingStatusRepository.findById(id);
    }

    public List<BookingStatus> getAllBookingStatuses() {
        return bookingStatusRepository.findAll();
    }
}
