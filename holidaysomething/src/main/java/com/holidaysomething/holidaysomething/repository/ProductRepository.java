package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
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

  Product findProductById(Long id);

  Product findByProductCategoryIdAndId(Long productCategoryId, Long id);

  // 해당 카테고리의 판매량이 높은 순서로 상품 검색(자기 자신은 제외)
  // SELECT * FROM product WHERE product_category_id = :categoryId AND id != :productId ORDER BY selling_quantity DESC limit 5;
  // TODO 1 + N 문제 발생 어떻게 해결할까...
  @Query(value = "SELECT p FROM Product p WHERE p.productCategory.id = :categoryId AND id <> :productId ORDER BY sellingQuantity")
  Page<Product> findByProductCategoryIdAndIdIsNotOrderBySellingPrice(@Param("categoryId") Long productCategoryId, @Param("productId") Long productId, Pageable pageable);
}


