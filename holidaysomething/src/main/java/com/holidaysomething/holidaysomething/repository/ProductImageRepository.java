package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    @Query(value = "SELECT pi FROM ProductImage pi WHERE pi.product.id=(:productId) AND pi.category=(:categorySub)")
    List<ProductImage> findByProductIdAndCategory(@Param("productId") Long productId,@Param("categorySub") Long category);

    @Query(value = "SELECT pi FROM ProductImage pi WHERE pi.product.id=(:productId) AND pi.category=(:categorySub)")
    ProductImage findProductByProductIdAndCategory(@Param("productId") Long productId,@Param("categorySub") Long category);

    ProductImage findByStoredFileName(String storedFileName);

    List<ProductImage> findByProductId(Long productId);
}
