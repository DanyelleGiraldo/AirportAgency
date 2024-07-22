package com.airportagency.entities.TripBooking.application.hechos;

import java.util.List;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingGetAllService {
    private final TripBookingRepository tripBookingRepository;

    public TripBookingGetAllService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public List<TripBooking> getAllTripBookings(){
        return tripBookingRepository.findAll();
    }
}
