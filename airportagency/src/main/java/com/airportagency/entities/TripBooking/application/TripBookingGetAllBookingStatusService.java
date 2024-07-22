package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class TripBookingGetAllBookingStatusService {
    private final BookingStatusRepository bookingStatusRepository;

    public TripBookingGetAllBookingStatusService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    public List<BookingStatus> getAllBookingStatuses() {
        return bookingStatusRepository.findAll();
    }
}
