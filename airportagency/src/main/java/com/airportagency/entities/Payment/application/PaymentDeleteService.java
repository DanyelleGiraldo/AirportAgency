package com.airportagency.entities.Payment.application;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;

public class PaymentDeleteService {
    private final PaymentRepository paymentRepository;

    public PaymentDeleteService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void deletePayment(String id){
        paymentRepository.delete(id);
    }
}
