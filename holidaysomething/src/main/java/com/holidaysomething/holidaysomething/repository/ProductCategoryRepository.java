package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // admin : product searching by category(대분류)
    @Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentId IS NULL")
    public List<ProductCategory> findByProductBigCategoryContaining();

}
