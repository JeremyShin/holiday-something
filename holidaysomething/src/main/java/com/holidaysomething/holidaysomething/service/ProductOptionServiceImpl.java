package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {
    private ProductOptionRepository productOptionRepository;

    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public List<ProductOption> getAllProductOptions() {
        return productOptionRepository.findAll();
    }
}