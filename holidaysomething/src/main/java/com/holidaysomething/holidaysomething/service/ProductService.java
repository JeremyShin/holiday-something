package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  Page<Product> findByProductNameContaining(String productName, Pageable pageable);
  Page<Product> findByProductRegdate(LocalDateTime regdateStart, LocalDateTime regdateEnd, Pageable pageable);

  Page<Product> findAll(Pageable pageable);

  ProductImage saveProductImage(ProductImage productImage);

  List<Product> getAllProducts();

  Product getProduct(Long id);
}
