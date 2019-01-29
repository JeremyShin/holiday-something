package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.dto.SearchDto;
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

  List<Product> getAllProducts();

  Product getProduct(Long id);

  // 모든 상품 or 검색된 상품
  Page<Product> findProductAllOrSearch(SearchDto searchDto, Pageable pageable);

  Page<Product> findProducts(String productSearchClassificationValue,
      String productSearchClassificationInput, Long largeId, Long middleId, Long smallId,
      String productSearchDateValue, String productStartDateSelect, String productEndDateSelect,
      Pageable pageable);

  // 해당 카테고리의 판매량 Best 5 상품 가져오기 (자기 자신 제외)
  Page<Product> getBestFiveProduct(Long categoryId, Long productId);

  // productCategoryId 와 Id 를 이용하여 상품 불러오기
  Product getProduct(Long productCategoryId, Long id);
}