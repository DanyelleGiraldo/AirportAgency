package com.airportagency.entities.Payment.application;

import java.util.Optional;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class PaymentSearchTripBookingService {
    private final TripBookingRepository tripBookingRepository;

    public PaymentSearchTripBookingService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public Optional<TripBooking> getTripBookingById(String id) {
        return tripBookingRepository.findById(id);
    }
}
