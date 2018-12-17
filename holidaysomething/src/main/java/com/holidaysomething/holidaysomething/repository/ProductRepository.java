package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //모든 상품을 상풍명순으로 검색
    List<Product> findAlByOrderByName();

    //카테고리 번호로 상품을 검색
   List<Product> findByProductCategoryIdOrderByName(Long productCategoryId);
}
