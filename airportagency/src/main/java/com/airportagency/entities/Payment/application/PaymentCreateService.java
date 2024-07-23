package com.airportagency.entities.Payment.application;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;
import com.airportagency.entities.Payment.domain.entity.Payment;


public class PaymentCreateService {
    private final PaymentRepository paymentRepository;

    public PaymentCreateService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    
    public void createPayment(Payment payment)   {
        paymentRepository.save(payment);
    }
    
}
