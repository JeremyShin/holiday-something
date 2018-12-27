package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PersistenceConfig.class })
@Transactional
@Rollback
public class ProductDslTest {

  private ProductRepository repo;

  public ProductDslTest(ProductRepository repo) {
    this.repo = repo;
  }

  private Product productJohn;
  private Product productTom;

  @Before
  public void init() {
    productJohn = new Product();
    productJohn.setCode("A123");
    productJohn.setName("으엉");
    productJohn.setSellingPrice(7400);
    productJohn.setOptionalPriceText("공짜");
    repo.save(productJohn);

    productTom= new Product();
    productTom.setCode("B451");
    productTom.setName("아하");
    productTom.setSellingPrice(3556);
    productTom.setOptionalPriceText("매진");
    repo.save(productTom);
  }

  @Test
  public void givenLast_whenGettingListOfUsers_thenCorrect() {
    ProductPredicatesBuilder builder = new ProductPredicatesBuilder().with("code", ":", "B451");

    Iterable<Product> results = repo.findAll(builder.build());
//    assertThat(results, containsInAnyOrder(productJohn, productTom));
  }
}
