package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Page<Product> findByProductNameContaining(String productName, Pageable pageable);
}
