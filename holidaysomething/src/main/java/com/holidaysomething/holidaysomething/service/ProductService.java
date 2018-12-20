package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import java.util.List;

import com.holidaysomething.holidaysomething.dto.ProductSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

  Page<Product> findByProductNameContaining(String productName, Pageable pageable);
//    List<ProductCategory> findByProductBigCategoryContaining();
//    List<ProductCategory> findByProductMiddleCategoryContaining(Long bigId);

  Page<Product> findAll(Pageable pageable);

  ProductImage saveProductImage(ProductImage productImage);

  List<Product> getAllProducts();

  Product getProduct(Long id);

  // 모든 상품 or 검색된 상품 by Jun
  Page<Product> findProductAllOrSearch(ProductSearch productSearch, Pageable pageable);
}
