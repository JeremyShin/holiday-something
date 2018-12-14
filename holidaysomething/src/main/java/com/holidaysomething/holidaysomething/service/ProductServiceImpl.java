package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Product> findByProductNameContaining(String productName, Pageable pageable) {
        Page<Product> productByName = productRepository.findbyProductNameContaining(productName, pageable);
        return productByName;
    }

    @Override
    public List<ProductCategory> findByProductBigCategoryContaining() {
        List<ProductCategory> productCategories = productRepository .findByProductBigCategoryContaining();
        return productCategories;
    }
}
