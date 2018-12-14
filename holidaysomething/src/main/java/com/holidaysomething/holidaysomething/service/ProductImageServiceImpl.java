package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductImageServiceImpl implements ProductImageService{
    private ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository){
        this.productImageRepository = productImageRepository;
    }

    @Override
    public void addProductImage(ProductImage productImage){
        productImageRepository.save(productImage);
    }
}
