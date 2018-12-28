package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.dto.Search;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  //Product findByProductNameContaining(String productName);

  Page<Product> findByProductNameContaining(String productName, Pageable pageable);

  Page<Product> findByProductRegdate(LocalDateTime regdateStart, LocalDateTime regdateEnd,
      Pageable pageable);

  Page<Product> findAll(Pageable pageable);

  ProductImage saveProductImage(ProductImage productImage);

  List<Product> getAllProducts();

  Product getProduct(Long id);

  // 모든 상품 or 검색된 상품 by Jun
  Page<Product> findProductAllOrSearch(Search search, Pageable pageable);

  Page<Product> findByProductCategory(Long categoryId, Pageable pageable);

  Page<Product> findByProductClassification(String SearchClassificationValue, String productSearchClassificationInput, Pageable pageable);
}
