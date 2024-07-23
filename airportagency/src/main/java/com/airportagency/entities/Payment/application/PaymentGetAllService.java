package com.airportagency.entities.Payment.application;

import java.util.List;

import com.airportagency.entities.Payment.domain.Service.PaymentRepository;
import com.airportagency.entities.Payment.domain.entity.Payment;

public class PaymentGetAllService {
    private final PaymentRepository paymentRepository;

    public PaymentGetAllService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }
}
