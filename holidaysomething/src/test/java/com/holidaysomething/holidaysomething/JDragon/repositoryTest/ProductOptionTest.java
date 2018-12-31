package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.product.ProductOptionRepository;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductOptionTest {

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
      .getLogger(ProductOptionTest.class);


  @Autowired
  ProductOptionRepository productOptionRepository;

  Pageable pageable;

  @Before
  public void pageable생성하기() {
    pageable = PageRequest.of(0, 5);

  }

  @Test
  public void 특정상품옵션들조회하기() {

    Page<ProductOption> productOptions = productOptionRepository.findByProductId(1l, pageable);
    log.info("productOptions.getContent() : " + productOptions.getContent().size());
    for (ProductOption productOption : productOptions) {
      log.info(productOption.getName());
    }

    productOptions = productOptionRepository.findByProductId(1l, pageable.next());
    for (ProductOption productOption : productOptions) {
      log.info(productOption.getName());
    }

    log.info("productOptions.getTotalPages() : " + productOptions.getTotalPages());
    log.info("productOptions.getTotalElements() : " + productOptions.getTotalElements());
    log.info("pageable.getPageNumber() : " + pageable.getPageNumber());
    log.info("pageable.hasPrevious() : " + pageable.hasPrevious());
  }

}
