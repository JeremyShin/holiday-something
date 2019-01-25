package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description 유저 상품 리스트 화면 테스트하기 /product/{categoryId}
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@Slf4j
public class ProductListTest {

  @Autowired
  private ProductRepository productRepository;

  Pageable pageable;

  @Before
  public void setUp() {
    pageable = PageRequest.of(0, 2);

  }


  @Test
  public void 카테고리별상품리스트조회() {
    Page<Product> products = productRepository.findProductByCategoryId(43l, pageable);

    assertThat(products.getTotalElements(), is(3));
  }

  @Test
  public void 카테고리별상품과이미지조회() {
    Page<ProductListImageDto> products = productRepository
        .findProductsImageByCategoryId(43l, pageable);

    //assertThat(products.getTotalElements(), is(3l));
    assertThat(products.getTotalElements(), is(3l));
  }
}
