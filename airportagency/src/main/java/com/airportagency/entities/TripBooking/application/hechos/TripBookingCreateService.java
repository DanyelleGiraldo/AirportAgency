package com.airportagency.entities.TripBooking.application.hechos;

import com.airportagency.entities.TripBooking.domain.entity.TripBooking;
import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingCreateService {
    
    private final TripBookingRepository tripBookingRepository;
    
    

    public TripBookingCreateService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }



    public void createTripBooking(TripBooking tripBooking){
        tripBookingRepository.save(tripBooking);
    }
}
