package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    List<ProductOption> findAllByNameContaining(String name);

//    Page<ProductOption> findAll(Pageable pageable);

    @Query(value = "select po from ProductOption po where po.name LIKE CONCAT('%', :productOptionName, '%')")
    Page<ProductOption> findAllProductOptionByNameContaining(@Param("productOptionName") String productOptionName, Pageable pageable);
}
