package com.airportagency.entities.TripBooking.application.hechos;

import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingDeleteService {
    private final TripBookingRepository tripBookingRepository;

    public TripBookingDeleteService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public void deleteTripBooking(String id){
            tripBookingRepository.delete(id);
        }
}
