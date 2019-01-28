package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
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

  //Product findByProductNameContaining(@Param("productName") String productName);

  //admin : product searching by code
  @Query(value = "SELECT p FROM Product p WHERE p.code LIKE CONCAT('%', :productCode, '%')")
  Page<Product> findByProductCodeContaining(@Param("productCode") String productCode,
      Pageable pageable);

  //admin : product searching by date
  @Query(value = "SELECT p FROM Product p WHERE p.regDate BETWEEN :regdateStart AND :regdateEnd")
  Page<Product> findByProductRegdate(@Param("regdateStart") LocalDateTime regdateStart,
      @Param("regdateEnd") LocalDateTime regdateEnd, Pageable pageable);

  //admin : product searching by releaseDate
  @Query(value = "SELECT p FROM Product p WHERE p.releaseDate = :releaseDate")
  Page<Product> findByProductReleaseDate(@Param("releaseDate") LocalDateTime releaseDate,
      Pageable pageable);

  // 상품 이미지 저장하기
  ProductImage save(ProductImage productImage);

  @Query("select count(p) from Product p")
  int countAll();

  //모든 상품을 상풍명순으로 검색
  List<Product> findAlByOrderByName();

  /************* '검색분류'로 검색하는 경우 *************************************************************/
  @Query(value = "SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
  Page<Product> findProductByName(@Param("name") String name, Pageable pageable);

  @Query(value = "SELECT p FROM Product p WHERE p.code = :code")
  Page<Product> findProductByCode(@Param("code") String code, Pageable pageable);

  @Query(value = "SELECT p FROM Product p WHERE p.sellingPrice = :sellingPrice")
  Page<Product> findProductBySellingPrice(@Param("sellingPrice") int sellingPrice,
      Pageable pageable);

  @Query(value = "SELECT p FROM Product p WHERE p.manufacturer LIKE CONCAT('%', :manufacturer, '%')")
  Page<Product> findProductByManufacturer(@Param("manufacturer") String manufacturer,
      Pageable pageable);

  @Query(value = "SELECT p FROM Product p WHERE p.optionalPriceText LIKE CONCAT('%', :optionalPriceText, '%')")
  Page<Product> findProductByOptionalPriceText(@Param("optionalPriceText") String optionalPriceText,
      Pageable pageable);

  @Query(value = "SELECT p FROM Product p WHERE p.shippingPrice = :shippingPrice")
  Page<Product> findProductByShippingPrice(@Param("shippingPrice") int shippingPrice,
      Pageable pageable);
  /************************************************************* '검색분류'로 검색하는 경우 *************/

  /********** User *************/
  // 카테고리 id 로 상품 조회하기.
  @Query(value = "SELECT p FROM Product p WHERE p.productCategory.id = :categoryId")
  Page<Product> findProductByCategoryId(@Param("categoryId") long categoryId, Pageable pageable);


  //  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p,pi.path,pi.storedFileName) FROM Product p join fetch ProductImage pi on p.id=pi.product.id join fetch ProductCategory pc on pc.id=p.productCategory.id where pi.category=1 and pc.id=:categoryId")
  //  List<ProductListImageDto> findProductsImageByCategoryId(@Param("categoryId") long categoryId);
  // 소분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.name,p.sellingPrice,p.originalPrice,p.quantity,p.safeQuantity,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.id=:categoryId")
  Page<ProductListImageDto> findProductsImageByCategoryId(@Param("categoryId") long categoryId,
      Pageable pageable);

  // 중분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.name,p.sellingPrice,p.originalPrice,p.quantity,p.safeQuantity,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.parentId=:categoryId")
  Page<ProductListImageDto> findProductsImageByCategoryId2(@Param("categoryId") long categoryId,
      Pageable pageable);

  // 대분류 조회하기
  @Query(value = "SELECT new com.holidaysomething.holidaysomething.dto.ProductListImageDto(p.name,p.sellingPrice,p.originalPrice,p.quantity,p.safeQuantity,p.optionalPriceText,pi.path,pi.storedFileName,pc.id) FROM Product p JOIN FETCH ProductImage pi ON p.id=pi.product.id JOIN FETCH ProductCategory pc ON pc.id=p.productCategory.id WHERE pi.category=1 AND pc.id IN (SELECT pc2.id FROM ProductCategory pc2 WHERE pc2.parentId IN (SELECT pc3.id FROM ProductCategory pc3 WHERE pc3.parentId = :categoryId))")
  Page<ProductListImageDto> findProductsImageByCategoryId3(@Param("categoryId") long categoryId,
      Pageable pageable);



}


