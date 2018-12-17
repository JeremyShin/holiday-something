package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  //결제수단 정보
}
