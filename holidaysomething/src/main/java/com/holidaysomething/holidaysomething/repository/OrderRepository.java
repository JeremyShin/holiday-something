package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
