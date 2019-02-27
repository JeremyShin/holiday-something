package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {

}
