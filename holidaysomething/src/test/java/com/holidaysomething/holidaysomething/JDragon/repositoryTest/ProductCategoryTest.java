package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductCategoryTest {
//
//  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
//      .getLogger(ProductCategoryTest.class);
//
//  @Autowired
//  ProductCategoryRepository productCategoryRepository;
//
//  @Test
//  public void 카테고리전체읽어와버리기() {
//    List<ProductCategory> categories = productCategoryRepository.findAll();
//    for (ProductCategory pc : categories) {
//      log.info(pc.getName());
//    }
//
//  }
//
//  @Test
//  public void 대분류카테고리만읽어와버리기() {
//    List<ProductCategory> categories = productCategoryRepository.findCategory(0l);
//    for (ProductCategory pc : categories) {
//      log.info(pc.getName());
//    }
//  }
//
//  @Test
//  public void 낮은분류카테고리읽어오기() {
//    List<ProductCategory> categories = productCategoryRepository.findCategory(1l);
//    for (ProductCategory pc : categories) {
//      log.info(pc.getName());
//    }
//  }
}
