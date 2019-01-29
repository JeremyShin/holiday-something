//package com.holidaysomething.holidaysomething.JDragon.serviceTest;
//
//import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
//import com.holidaysomething.holidaysomething.service.product.ProductListService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//
//
///**
// * @author choijaeyong on 25/01/2019.
// * @project holidaysomething
// * @description
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class ProductListServiceTest {
//
//  @Autowired
//  private ProductListService productListService;
//
//  Pageable pageable;
//
//  @Before
//  public void pageable생성하기() {
//    pageable = PageRequest.of(0, 1);
//
//  }
//
//  @Test
//  public void 상품리스트와이미지조회하는서비스() {
//    Page<ProductListImageDto> products = productListService.productList(43l,pageable);
//
//    assertThat(products.getTotalPages(),is(3));
//  }
//
//}
