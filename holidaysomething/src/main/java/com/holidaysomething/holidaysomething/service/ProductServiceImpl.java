package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
  
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAlByOrderByName();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        return productRepository.getOne(id);

    @Transactional
    @Override
    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public ProductImage saveProductImage(ProductImage productImage){
        return productRepository.save(productImage);
    }
}
