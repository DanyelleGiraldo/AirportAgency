package com.airportagency.entities.Payment.application;

import java.util.Optional;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;
import com.airportagency.entities.Payment.domain.entity.Payment;

public class PaymentSearchService {
    private final PaymentRepository paymentRepository;

    public PaymentSearchService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<Payment> findById(String id){
        return paymentRepository.findById(id);
    }
}
