package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
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

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
      .getLogger(ProductCategoryTest.class);

  @Autowired
  ProductCategoryRepository productCategoryRepository;

  @Test
  public void 카테고리전체읽어와버리기() {
    List<ProductCategory> categories = productCategoryRepository.findAll();
    for (ProductCategory pc : categories) {
      log.info(pc.getName());
    }

  }

  @Test
  public void 카테고리읽어와버리기() {
    List<ProductCategory> categories = productCategoryRepository.findCategory(0l);
    for (ProductCategory pc : categories) {
      log.info(pc.getName());
    }
  }


  // 소분류 아이디를 이용해 대분류 중분류 구하기.
  @Test
  public void 대중분류카테고리읽어오기() {
    ProductListCategoryDto category = productCategoryRepository.findProductCategories(42l);
    log.info("====== parent_id : " + category.getParentId() + "   parent_name : " + category
        .getParentName()
        + "    child_id : " + category.getChildId() + "  child_name : " + category.getChildName());
  }

  // 중분류 아이디를 이용해 대분류 구하기
  @Test
  public void 대분류카테고리읽어오기() {
    ProductCategory category = productCategoryRepository.findProductBigCategory(37l);
    log.info("====== parent_id : " + category.getId() + "   parent_name : " + category.getName());
  }

}
