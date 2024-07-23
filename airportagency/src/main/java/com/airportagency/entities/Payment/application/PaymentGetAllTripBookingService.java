package com.airportagency.entities.Payment.application;

import java.util.List;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class PaymentGetAllTripBookingService {
    private final TripBookingRepository tripBookingRepository;

    public PaymentGetAllTripBookingService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public List<TripBooking> getAllTripBookings() {
        return tripBookingRepository.findAll();
    }
}
