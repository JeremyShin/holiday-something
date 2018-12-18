package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class productTest {

  ProductRepository productRepository;

  @Test
  public void 상품명순으로_모든_상품가져오기() throws Exception {
    List<Product> products = productRepository.findAlByOrderByName();
    for (Product product : products) {
      System.out.println("상품명은" + product.getName() + "상품코드는 " + product.getCode());
    }
  }
}
