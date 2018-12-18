package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    List<ProductOption> findAllByNameContaining(String name);

    @Query(value = "select po from ProductOption po where po.name LIKE CONCAT('%', :productOptionName, '%')")
    Page<ProductOption> findAllProductOptionByNameContaining(@Param("productOptionName") String productOptionName, Pageable pageable);

    @Query(value = "select po from ProductOption po where po.description LIKE CONCAT('%', :productOptionDescription, '%')")
    Page<ProductOption> findAllProductOptionByDescriptionContaining(@Param("productOptionDescription") String productOptionDescription, Pageable pageable);

    @Query(value = "select po from ProductOption po where po.price LIKE CONCAT('%', :productOptionPrice, '%')")
    Page<ProductOption> findAllProductOptionByPriceContaining(@Param("productOptionPrice") String productOptionPrice, Pageable pageable);

    ProductOption save(ProductOption productOption);
  // 전체 옵션 출력하기!
    List<ProductOption> findAll();
}
