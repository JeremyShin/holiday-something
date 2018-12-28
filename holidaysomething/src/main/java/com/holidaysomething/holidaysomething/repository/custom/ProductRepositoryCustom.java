package com.holidaysomething.holidaysomething.repository.custom;

import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {

  Page<Product> findProducts(String searchClassificationValue, String searchClassificationInput, Pageable pageable);
}
