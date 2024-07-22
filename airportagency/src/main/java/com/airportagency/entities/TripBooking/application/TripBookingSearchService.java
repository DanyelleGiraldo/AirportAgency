package com.airportagency.entities.TripBooking.application;

import java.util.Optional;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingSearchService {
    private final TripBookingRepository tripBookingRepository;
    
    public TripBookingSearchService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }
    
    public Optional<TripBooking> getTripBookingById(String id){
        return tripBookingRepository.findById(id);
    }
}
