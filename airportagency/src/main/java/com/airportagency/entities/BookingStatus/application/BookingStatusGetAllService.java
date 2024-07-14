package com.airportagency.entities.BookingStatus.application;

import java.util.List;

import com.airportagency.entities.BookingStatus.domain.entity.BookingStatus;
import com.airportagency.entities.BookingStatus.domain.service.BookingStatusRepository;

public class BookingStatusGetAllService {
    private final BookingStatusRepository bookingStatusRepository;

    public BookingStatusGetAllService(BookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    public List<BookingStatus> getAllBookingStatus(){
        return bookingStatusRepository.findAll();
    }
}
