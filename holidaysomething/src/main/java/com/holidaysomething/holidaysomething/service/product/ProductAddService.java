package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductAddService {

  // 모든 상품 리스트 가져오기
  Page<Product> getAllProducts(Pageable pageable);

  // 상품 중,소분류 카테고리 읽어오기야!
  List<ProductCategory> productCategoryList(Long parentId);

  // 상품 등록하기 전에 DTO를 Domain 객체로 만들어주깅
  Product productDtoToProduct(ProductDto productDto);

  // 상품 등록 하기야!! (상품, 상품_디테일 테이블 두개 insert)
  Product productRegister(Product product);
}