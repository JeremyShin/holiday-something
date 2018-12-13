package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {

//    @Query(value="select me from Member me where me.loginId=(:loginId)")
//    ProductOption findByIdContaining(@Param("loginId") String loginId);
//
//    List<ProductOption> findByOrderIdOrderByProductId(Long orderId);


}