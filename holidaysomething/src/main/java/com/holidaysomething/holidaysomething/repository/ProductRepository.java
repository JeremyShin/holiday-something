package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.repository.custom.ProductRepositoryCustom;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

  //admin : product searching by name
  @Query(value = "SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :productName, '%')")
  Page<Product> findByProductNameContaining(@Param("productName") String productName,
      Pageable pageable);

  //admin : product searching by code
  @Query(value = "SELECT p FROM Product p WHERE p.code LIKE CONCAT('%', :productCode, '%')")
  Page<Product> findByProductCodeContaining(@Param("productCode") String productCode,
      Pageable pageable);

  //admin : product searching by date
  @Query(value = "SELECT p FROM Product p WHERE p.regDate BETWEEN :regdateStart AND :regdateEnd")
  Page<Product> findByProductRegdate(@Param("regdateStart") LocalDateTime regdateStart,
      @Param("regdateEnd") LocalDateTime regdateEnd, Pageable pageable);

  @Query("select count(p) from Product p")
  int countAll();

  //모든 상품을 상풍명순으로 검색
  List<Product> findAllByOrderByName();

  Product findByProductCategoryIdAndId(Long productCategoryId, Long id);

  // 소분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.id,p.name,p.sellingPrice,p.originalPrice,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.id=:categoryId")
  Page<ProductListImageDto> findProductsImageByCategoryId(@Param("categoryId") long categoryId,
      Pageable pageable);

  // 중분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.id,p.name,p.sellingPrice,p.originalPrice,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.parentId=:categoryId")
  Page<ProductListImageDto> findProductsImageByCategoryId2(@Param("categoryId") long categoryId,
      Pageable pageable);

  // 대분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.id,p.name,p.sellingPrice,p.originalPrice,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.id IN (SELECT pc2.id FROM ProductCategory pc2 WHERE pc2.parentId IN (SELECT pc3.id FROM ProductCategory pc3 WHERE pc3.parentId = :categoryId))")
  Page<ProductListImageDto> findProductsImageByCategoryId3(@Param("categoryId") long categoryId,
      Pageable pageable);
}


