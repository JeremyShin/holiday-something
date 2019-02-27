package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

  List<ProductCategory> findByParentId(Long parentId);

  @Query(value = "select pc from ProductCategory pc where pc.parentId=(:parentId)")
  List<ProductCategory> findCategory(@Param("parentId") Long parentId);

  @Query(value = "select pc from ProductCategory pc where pc.id=(:id)")
  ProductCategory findByIdContaining(@Param("id") Long id);

  @Query(value = "select pc from ProductCategory  pc where pc.id= :id")
  ProductCategory findProductCategoryById(@Param("id") Long id);

  // 소분류 아이디를 이용해 대분류 중분류 구하기.
  @Query(value = "select new com.holidaysomething.holidaysomething.dto.ProductListCategoryDto(pc.id,pc.name,pc2.id,pc2.name) from ProductCategory pc join fetch ProductCategory pc2 on pc.parentId=pc2.id where pc.id = (select pc3.parentId from ProductCategory pc3 where pc3.id=:categoryId)")
  ProductListCategoryDto findProductCategories(@Param("categoryId") Long categoryId);

  // 중분류 아이디를 이용해 대분류 구하기
  @Query(value = "select pc from ProductCategory pc where pc.id = (select pc2.parentId from ProductCategory pc2 where pc2.id=:categoryId)")
  ProductCategory findProductBigCategory(@Param("categoryId") Long categoryId);
}
