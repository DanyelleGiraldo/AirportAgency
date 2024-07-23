package com.airportagency.entities.Payment.application;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class PaymentCreateTripBookingService {
    private final TripBookingRepository tripBookingRepository;

    public PaymentCreateTripBookingService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public void createTripBooking(TripBooking tripBooking) {
        tripBookingRepository.save(tripBooking);
    }
}
