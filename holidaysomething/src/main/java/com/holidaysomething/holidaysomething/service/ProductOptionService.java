package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;

import java.util.List;

public interface ProductOptionService {
    List<ProductOption> getAllProductOptions();
    ProductOption getProductOption(Long id);
    void deleteProductOption(Long id);
}