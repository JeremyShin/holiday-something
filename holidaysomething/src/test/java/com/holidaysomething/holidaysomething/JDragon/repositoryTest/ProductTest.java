package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductTest {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductDetailRepository productDetailRepository;


  @Test
  public void 전체상품갯수조회하기() {
    int count = productRepository.countAll();
    System.out.println("========================= " + count);
  }


  @Test
  public void 상품등록하깃() {
    ProductDetail pd = new ProductDetail("");
    pd.setDescription("이거 방탄 펜슬이야!!");
    ProductDetail pds = productDetailRepository.save(pd);
    Product p = new Product();

    p.setName("애플펜슬");
    p.setManufacturer("삼성");
    p.setCode("ajax1234");
    p.setOriginalPrice(500);
    p.setSellingPrice(10000000);
    p.setManufacturingPrice(100);
    p.setShippingPrice(50000);
    p.setProductDetail(pds);
    // 상품설명과 카테고리는 fk

    Product pp = productRepository.save(p);

    System.out.println("================================");
    System.out.println("상품설명 id : " + pds.getId());
    System.out.println("상품 id : " + pp.getId());
    System.out.println("상품의 getProductDetail().getId() : " + pp.getProductDetail().getId());
  }

  @Test
  public void 날짜테스트하기() {
    LocalDateTime ldt = LocalDateTime.now();
    System.out.println("======================= ldt : " + ldt);

    ldt = LocalDateTime.now(ZoneId.systemDefault());
    System.out.println("======================= ldt : " + ldt);
  }

}
