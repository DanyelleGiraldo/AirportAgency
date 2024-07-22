package com.airportagency.entities.Payment.application;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;
import com.airportagency.entities.PaymentMethod.domain.service.PaymentMethodRepository;

public class PaymentCreateService {
    private final PaymentRepository paymentRepository;

    private final PaymentMethodRepository paymentMethodRepository;

    private final TripBookingRepository tripBookingRepository;

    public PaymentCreateService(PaymentRepository paymentRepository, PaymentMethodRepository paymentMethodRepository,
            TripBookingRepository tripBookingRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.tripBookingRepository = tripBookingRepository;
    }

    
    
}
