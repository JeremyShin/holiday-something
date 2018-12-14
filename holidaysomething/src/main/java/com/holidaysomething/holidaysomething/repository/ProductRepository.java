package com.holidaysomething.holidaysomething.repository;


import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // admin : product searching by name
    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :productName, '%')")
    public Page<Product> findbyProductNameContaining(@Param("productName") String productName, Pageable pageable);

    // admin : product searching by category(대분류)
    @Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentId IS NULL")
    public List<ProductCategory> findByProductBigCategoryContaining();

    // admin : product searching by category(중분류)
    //@Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentId = :id")
    @Query(value = "SELECT pc FROM ProductCategory pc ")
    public List<ProductCategory> findByProductMiddleCategoryContaining(Long id);

}


