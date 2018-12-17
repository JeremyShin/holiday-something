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
    @Query(value = "SELECT c FROM ProductCategory c LEFT JOIN c.parentProductCategory WHERE c.id=:id")
    public List<ProductCategory> findByProductMiddleCategoryContaining(@Param("id") Long id);
}
