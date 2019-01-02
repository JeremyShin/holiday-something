package com.holidaysomething.holidaysomething;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductOptionServiceTest {

  @Autowired
  private ProductOptionService productOptionService;

  @Test
  public void 테스트jjjjj() throws Exception {
    List<ProductOption> productOptions = productOptionService.getAllProductOptions();
    System.out.println("ㅋㅋㅋ" + productOptions.size());
  }
}
