package com.airportagency.entities.Payment.domain.Service;

import java.util.List;
import java.util.Optional;

import com.airportagency.entities.Payment.domain.entity.Payment;

public interface PaymentRepository {
    void save(Payment payment);
    void update(Payment payment);
    Optional<Payment> findById(String id);
    void delete(String id);
    List<Payment> findAll();
}
