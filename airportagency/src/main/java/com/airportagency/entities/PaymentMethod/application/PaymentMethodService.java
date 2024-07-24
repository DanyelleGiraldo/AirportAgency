package com.airportagency.entities.PaymentMethod.application;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;
import com.airportagency.entities.PaymentMethod.domain.service.PaymentMethodRepository;

public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void createPayMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    public Optional<PaymentMethod> getPayMethodById(int id) {
        return paymentMethodRepository.findById(id);
    }

    public List<PaymentMethod> getAllPayMethods() {
        return paymentMethodRepository.findAll();
    }
}
