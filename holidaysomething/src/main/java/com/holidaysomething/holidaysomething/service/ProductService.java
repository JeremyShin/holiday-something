package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import java.util.List;    
import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    ProductImage saveProductImage(ProductImage productImage);
    List<Product> getAllProducts();
    Product getProduct(Long id);
}
