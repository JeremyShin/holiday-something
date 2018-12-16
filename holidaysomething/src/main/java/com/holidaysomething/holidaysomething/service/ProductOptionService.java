package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductOptionService {
    List<ProductOption> getAllProductOptions();
    ProductOption getProductOption(Long id);
    void deleteProductOption(Long id);
    List<ProductOption> getAllProductOptionsByName(String name);
    Page<ProductOption> getAllProductOptionsPage(Pageable pageable);
    Page<ProductOption> getAllProductOptionsByNamePage(String name, Pageable pageable);
}