package com.holidaysomething.holidaysomething.repository.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

  // admin : product searching by category(대분류)
//  @Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentProductCategory IS NULL")
//  List<ProductCategory> findByProductBigCategoryContaining();

  // admin : product searching by category(중분류)
//  @Query(value = "SELECT c FROM ProductCategory c LEFT JOIN c.parentProductCategory WHERE c.parentProductCategory.id =:id")
//  List<ProductCategory> findByProductMiddleCategoryContaining(@Param("id") Long id);

  List<ProductCategory> findByParentId(Long parentId);

  @Query(value = "select pc from ProductCategory pc where pc.parentId=(:parentId)")
  List<ProductCategory> findCategory(@Param("parentId") Long parentId);

  @Query(value = "select pc from ProductCategory pc where pc.id=(:id)")
  ProductCategory findByIdContaining(@Param("id") Long id);
}
