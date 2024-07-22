package com.airportagency.entities.TripBooking;

import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingCancelService {
        private final TripBookingRepository tripBookingRepository;

        public TripBookingCancelService(TripBookingRepository tripBookingRepository) {
            this.tripBookingRepository = tripBookingRepository;
        }
        
        public void cancelTripBooking(String id) {
            tripBookingRepository.cancelBooking(id);
        }
}
