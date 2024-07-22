package com.airportagency.entities.TripBooking.application;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class TripBookingCreateBookingStatusService {
    private final BookingStatusRepository bookingStatusRepository;

    public TripBookingCreateBookingStatusService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }
    
    public void createBookingStatus(BookingStatus bookingStatus) {
        bookingStatusRepository.save(bookingStatus);
    }

}
