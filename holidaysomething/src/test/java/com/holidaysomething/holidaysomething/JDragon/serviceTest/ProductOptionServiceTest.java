//package com.holidaysomething.holidaysomething.JDragon.serviceTest;
//
//
//import com.holidaysomething.holidaysomething.domain.ProductOption;
//import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
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
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class ProductOptionServiceTest {
//
//  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
//      .getLogger(ProductOptionServiceTest.class);
//
//
//  @Autowired
//  ProductOptionService productOptionService;
//
//
//  private Pageable pageable;
//
//  @Before
//  public void pageable생성하기() {
//    pageable = PageRequest.of(0, 5);
//
//  }
//
//  @Test
//  public void 상품당옵션들조회하기() {
//    Page<ProductOption> productOptions;
//
//    for (int i = 0; i < 2; i++) {
//      pageable = PageRequest.of(i, 5);
//      productOptions = productOptionService.getProductOptionsByProductId(1l, pageable);
//      for (ProductOption productOption : productOptions) {
//        log.info(productOption.getName());
//      }
//    }
//
//  }
//
//}
