package com.airportagency.entities.PaymentMethod.application;

import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;
import com.airportagency.entities.PaymentMethod.domain.service.PaymentMethodRepository;

public class PaymentMethodCreateService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodCreateService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void createPayMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }
}
