package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.stereotype.Service;

@Service
public interface ProductOptionService {
    public void addProductOption(ProductOption productOption);
}
