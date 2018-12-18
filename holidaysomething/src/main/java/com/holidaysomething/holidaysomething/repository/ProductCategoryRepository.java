package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByParentId(Long parentId);

    // 카테고리들 대/중/소 다 가져오기. 분류해서 출력하는건 Service? 나 프론트에서 할꺼야!


    public List<ProductCategory> findAll();


    @Query(value = "select pc from ProductCategory pc where pc.parentId=(:parentId)")
    public List<ProductCategory> findCategory(@Param("parentId") Long parentId);


    @Query(value = "select pc from ProductCategory pc where pc.id=(:id)")
    public ProductCategory findByIdContaining(@Param("id") Long id);
}
