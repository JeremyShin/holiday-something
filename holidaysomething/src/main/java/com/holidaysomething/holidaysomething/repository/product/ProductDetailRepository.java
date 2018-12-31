package com.holidaysomething.holidaysomething.repository.product;


import com.holidaysomething.holidaysomething.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

  // 상품 설명 등록
  ProductDetail save(ProductDetail productDetail);
}
