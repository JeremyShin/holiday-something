package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
public class ProductServiceTest {



    @Autowired
    AdminProductService adminProductService;

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
