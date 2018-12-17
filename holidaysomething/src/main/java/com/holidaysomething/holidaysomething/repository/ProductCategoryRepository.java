package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // admin : product searching by category(대분류)
    @Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentProductCategory IS NULL")
    public List<ProductCategory> findByProductBigCategoryContaining();

    //admin : product searching by category(중분류)
    @Query(value = "SELECT pc0, pc1 FROM ProductCategory pc0 JOIN pc0.productCategories pc1 WHERE pc1.id = :id")
    public List<ProductCategory> findByProductMiddleCategoryContaining(@Param("id") Long id);

    @Query(value = "SELECT pc FROM ProductCategory pc")
    public List<ProductCategory> findAll();

}
