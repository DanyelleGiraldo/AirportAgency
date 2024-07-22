package com.airportagency.entities.TripBooking.application;

import java.util.List;

import com.airportagency.entities.TripBooking.domain.service.TripBookingRepository;

public class TripBookingGetAllBookingStatusServiceStr {
    private final TripBookingRepository tripBookingRepository;

    public TripBookingGetAllBookingStatusServiceStr(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public List<String> getAllBookingStatusesStr() {
        return tripBookingRepository.findAllBookingTypes();
    }
}
