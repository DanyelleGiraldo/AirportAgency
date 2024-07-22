package com.airportagency.entities.TripBooking.application.tripbookingdetails;

import java.util.List;

public class TripBookingGetAllTripBookingDetailsService {
    private final TripBookingDetailsRepository tripBookingDetailsRepository;

    public TripBookingGetAllTripBookingDetailsService(TripBookingDetailsRepository tripBookingDetailsRepository) {
        this.tripBookingDetailsRepository = tripBookingDetailsRepository;
    }

     public List<TripBookingDetails> getAllTripBookingDetails() {
        return tripBookingDetailsRepository.findAll();
    }
}
