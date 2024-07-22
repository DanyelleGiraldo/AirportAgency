package com.airportagency.entities.TripBooking.application.hechos;

import java.util.Optional;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class TripBookingSearchBookingStatusService {
    private final BookingStatusRepository bookingStatusRepository;

    public TripBookingSearchBookingStatusService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }
    
    public Optional<BookingStatus> getBookingStatusById(int id) {
        return bookingStatusRepository.findById(id);
    }
}
