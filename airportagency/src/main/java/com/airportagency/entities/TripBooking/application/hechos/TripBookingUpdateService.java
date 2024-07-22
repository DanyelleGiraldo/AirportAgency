package com.airportagency.entities.TripBooking.application.hechos;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingUpdateService {
    private final TripBookingRepository tripBookingRepository;

    public TripBookingUpdateService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public void updateTripBooking(TripBooking tripBooking){
        tripBookingRepository.update(tripBooking);
    }
}
