package com.airportagency.entities.Payment.application;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;
import com.airportagency.entities.Payment.domain.entity.Payment;

public class PaymentUpdateService {
    private final PaymentRepository paymentRepository;

    public PaymentUpdateService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void updatePayment(Payment payment){
        paymentRepository.update(payment);
    }
}
