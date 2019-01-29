package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
//    @Query(value = "SELECT pi FROM ProductImage pi WHERE pi.productId=(:productId) AND pi.category=(:categorySub)")
    List<ProductImage> findByProductIdAndCategory(Long productId, Long category);

    ProductImage findByStoredFileName(String storedFileName);
}
