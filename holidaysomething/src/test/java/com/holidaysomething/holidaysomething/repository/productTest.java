//package com.holidaysomething.holidaysomething.repository;
//
//import com.holidaysomething.holidaysomething.domain.Product;
//import java.time.LocalDateTime;
//import java.util.List;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@Transactional
//public class productTest {
//
//  @Autowired
//  ProductRepository productRepository;
//
//  @Test
//  public void 상품명순으로_모든_상품가져오기() throws Exception {
//    List<Product> products = productRepository.findAllByOrderByName();
//    for (Product product : products) {
//      System.out.println("상품명은" + product.getName() + "상품코드는 " + product.getCode());
//    }
//  }
//
//  @Test
//  public void 이름포함된Product구하기() throws Exception {
//    Pageable pageable = PageRequest.of(0, 5);
//    Page<Product> products = productRepository.findByProductNameContaining("아이코닉", pageable);
//    System.out.println("================");
//    System.out.println(products.getTotalElements());
//    System.out.println(products.getTotalPages());
//    System.out.println("================");
//
//    for (Product product : products) {
//      System.out.println(product.getName());
//    }
//  }
//
//  @Test
//  public void 상품code순으로_모든_상품가져오기() throws Exception {
//
//    Pageable pageable = PageRequest.of(0, 5);
//    Page<Product> products = productRepository.findByProductCodeContaining("210", pageable);
//
//    for (Product product : products) {
//      System.out.println("상품명은" + product.getName() + "상품코드는 " + product.getCode());
//    }
//  }
//
//  @Test
//  public void 제품등록일로_상품가져오기() throws Exception {
//    Pageable pageable = PageRequest.of(0, 5);
//    Page<Product> products = productRepository
//        .findByProductRegdate(LocalDateTime.of(2018, 12, 20, 14, 22),
//            LocalDateTime.of(2018, 12, 30, 14, 22), pageable);
//
//    System.out.println("~~~~");
//    for (Product product : products) {
//      System.out.println(
//          product.getName() + ", " + product.getRegDate() + ", " + product.getReleaseDate());
//    }
//  }
//}
