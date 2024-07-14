package com.airportagency.entities.BookingStatus.application;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class BookingStatusCreateService {
    private final BookingStatusRepository bookingStatusRepository;

    public BookingStatusCreateService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }
    
    public void createBookingStatus(BookingStatus bookingStatus){
        bookingStatusRepository.save(bookingStatus);
    }
}
