package com.holidaysomething.holidaysomething.JDragon.serviceTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
      .getLogger(ProductServiceTest.class);


  @Autowired
  private ProductAddService productAddService;

  @Test
  public void 상품서비스에서등록하기테스트() {
    Product p = new Product();
    ProductDetail pd = new ProductDetail("이거 방탄유리야!!");
    ProductCategory pc = new ProductCategory();
    pc.setId(2l);
    pc.setName("하하");

    p.setName("애플펜슬2");
    p.setManufacturer("애플2");
    p.setCode("ajax12345");
    p.setOriginalPrice(500);
    p.setSellingPrice(10000000);
    p.setManufacturingPrice(100);
    p.setShippingPrice(50000);
    p.setProductDetail(pd);
    p.setProductCategory(pc);

    Product insertedProduct = productAddService.productRegister(p);

    log.info("================================");
    log.info("상품 id : " + insertedProduct.getId());
    log.info("상품 name : " + insertedProduct.getName());
    log.info("상품 description : " + insertedProduct.getProductDetail().getDescription());
    log.info("상품 category id : " + insertedProduct.getProductCategory().getId());
    log.info("상품 category name : " + insertedProduct.getProductCategory().getName());
  }


}
