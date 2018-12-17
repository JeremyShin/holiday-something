package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {
    private ProductOptionRepository productOptionRepository;

    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductOption> getAllProductOptions() {
        return productOptionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductOption getProductOption(Long id) {
        return productOptionRepository.getOne(id);
    }

    @Override
    public void deleteProductOption(Long id) {
        productOptionRepository.deleteById(id);
    }
}