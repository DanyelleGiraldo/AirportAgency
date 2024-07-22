package com.airportagency.entities.PaymentMethod.application;

import java.util.List;

import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;
import com.airportagency.entities.PaymentMethod.domain.service.PaymentMethodRepository;

public class PaymentMethodGetAllService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodGetAllService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPayMethods() {
        return paymentMethodRepository.findAll();
    }
}
