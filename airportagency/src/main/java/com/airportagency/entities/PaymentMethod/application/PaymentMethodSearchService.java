package com.airportagency.entities.PaymentMethod.application;

import java.util.Optional;

import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;
import com.airportagency.entities.PaymentMethod.domain.service.PaymentMethodRepository;

public class PaymentMethodSearchService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodSearchService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public Optional<PaymentMethod> getPayMethodById(int id) {
        return paymentMethodRepository.findById(id);
    }
}
