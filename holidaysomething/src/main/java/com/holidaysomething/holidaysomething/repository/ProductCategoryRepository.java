package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // 카테고리들 대/중/소 다 가져오기. 분류해서 출력하는건 Service? 나 프론트에서 할꺼야!


    public List<ProductCategory> findAll();

    @Query(value="select pc from ProductCategory pc where pc.parentId=null")
    public List<ProductCategory> findLevelOne();

    @Query(value="select pc from ProductCategory pc where pc.parentId=(:parentId)")
    public List<ProductCategory> findLowLevel(@Param("parentId") Long parentId);


    @Query(value="select pc from ProductCategory pc where pc.id=(:id)")
    public List<ProductCategory> findByIdContaining1(@Param("id") String id);


}
