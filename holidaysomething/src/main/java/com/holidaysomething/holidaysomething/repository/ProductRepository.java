package com.holidaysomething.holidaysomething.repository;


import com.holidaysomething.holidaysomething.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // admin : product searching by name
    @Query(value = "select p from Product p where p.name LIKE CONCAT('%', :productName, '%')")
    public Page<Product> findbyProductNameContaining(@Param("productName") String productName, Pageable pageable);


}


