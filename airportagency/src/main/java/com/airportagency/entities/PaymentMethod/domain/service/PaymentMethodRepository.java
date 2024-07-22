package com.airportagency.entities.PaymentMethod.domain.service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.PaymentMethod.domain.entity.PaymentMethod;

public interface  PaymentMethodRepository {
    void save(PaymentMethod paymentMethod);
    Optional<PaymentMethod> findById(int id);
    List<PaymentMethod> findAll();
}
