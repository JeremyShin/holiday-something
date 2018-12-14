package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductOptionRepository extends CrudRepository<ProductOption, Long> {
    ProductOption save(ProductOption productOption);
}
