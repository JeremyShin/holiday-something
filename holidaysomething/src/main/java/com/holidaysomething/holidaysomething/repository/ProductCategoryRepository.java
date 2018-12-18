package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // admin : product searching by category(대분류)
//     @Query(value = "SELECT pc FROM ProductCategory pc WHERE pc.parentProductCategory IS NULL")
//     public List<ProductCategory> findByProductBigCategoryContaining();

//     //admin : product searching by category(중분류)
//     @Query(value = "SELECT c FROM ProductCategory c LEFT JOIN c.parentProductCategory WHERE c.parentProductCategory.id =:id")
//     public List<ProductCategory> findByProductMiddleCategoryContaining(@Param("id") Long id);

  List<ProductCategory> findByParentId(Long parentId);

  // 카테고리들 대/중/소 다 가져오기. 분류해서 출력하는건 Service? 나 프론트에서 할꺼야!


  List<ProductCategory> findAll();


  @Query(value = "select pc from ProductCategory pc where pc.parentId=(:parentId)")
  List<ProductCategory> findCategory(@Param("parentId") Long parentId);


  @Query(value = "select pc from ProductCategory pc where pc.id=(:id)")
  ProductCategory findByIdContaining(@Param("id") Long id);
}
