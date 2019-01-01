package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDslTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void queryDsl_검색분류_테스트() throws Exception {
    Pageable pageable = PageRequest.of(0, 30);

    Page<Product> productPage = productRepository.findProducts("productManufacturer","인천",
        1L, null, null, "manufactureDate", "2018-04-01", "2018-11-31", pageable);
  }
}
