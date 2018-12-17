package com.holidaysomething.holidaysomething.repository;


import com.holidaysomething.holidaysomething.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    // 상품 설명 등록
    public ProductDetail save(ProductDetail productDetail);
}
