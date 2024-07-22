package com.airportagency.entities.TripBooking.application.tripbookingdetails;



public class TripBookingCreateTripBookingDetailsService {
    private final TripBookingDetailsRepository tripBookingDetailsRepository;

    public TripBookingCreateTripBookingDetailsService(TripBookingDetailsRepository tripBookingDetailsRepository) {
        this.tripBookingDetailsRepository = tripBookingDetailsRepository;
    }

    public void createTripBookingDetails(TripBookingDetails tripBookingDetails){
        tripBookingDetailsRepository.save(tripBookingDetails);
    }
}
