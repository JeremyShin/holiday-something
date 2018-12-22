package com.holidaysomething.holidaysomething.JDragon.repositoryTest;


import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
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
    System.out.println("productOptions.getContent() : " + productOptions.getContent().size());
    for (ProductOption productOption : productOptions) {
      System.out.println(productOption.getName());
    }

    productOptions = productOptionRepository.findByProductId(1l, pageable.next());
    for (ProductOption productOption : productOptions) {
      System.out.println(productOption.getName());
    }

    System.out.println("productOptions.getTotalPages() : " + productOptions.getTotalPages());
    System.out.println("productOptions.getTotalElements() : " + productOptions.getTotalElements());
    System.out.println("pageable.getPageNumber() : " + pageable.getPageNumber());
    System.out.println("pageable.hasPrevious() : " + pageable.hasPrevious());

  }

}
