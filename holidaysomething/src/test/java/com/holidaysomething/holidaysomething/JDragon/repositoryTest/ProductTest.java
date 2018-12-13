package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Autowired
    AdminProductService adminProductService;

    @Test
    public void 전체상품갯수조회하기() {
        int count = productRepository.countAll();
        System.out.println("========================= " + count);
    }




    @Test
    public void 상품등록하깃() {
        ProductDetail pd = new ProductDetail("");
        pd.setDescription("상품 설명이다!!!!!!!!!");
        ProductDetail pds = productDetailRepository.save(pd);



        Product p = new Product();

        p.setName("애플펜슬");
        p.setManufacturer("애플");
        p.setCode("ajax1234");
        p.setOriginalPrice(500);
        p.setSellingPrice(10000000);
        p.setManufacturingPrice(100);
        p.setShippingPrice(50000);
        p.setProductDetail(pds);
        // 상품설명과 카테고리는 fk

        Product pp = productRepository.save(p);

        System.out.println("================================");
        System.out.println("상품설명 id : "+pds.getId());
        System.out.println("상품 id : "+pp.getId());
        System.out.println("상품의 getProductDetail().getId() : " + pp.getProductDetail().getId());
    }

    @Test
    public void 상품서비스에서등록하기테스트() {
        Product p = new Product();

        p.setName("애플펜슬2");
        p.setManufacturer("애플2");
        p.setCode("ajax12345");
        p.setOriginalPrice(500);
        p.setSellingPrice(10000000);
        p.setManufacturingPrice(100);
        p.setShippingPrice(50000);

        Product pp = adminProductService.productRegister(p,"애플펜슬2 설명입니다!!!!!!");

        System.out.println("================================");
        System.out.println("상품설명 id : "+ pp.getProductDetail().getId());
        System.out.println("상품설명 description : "+ pp.getProductDetail().getDescription());
        System.out.println("상품 id : "+pp.getId());



    }


}
