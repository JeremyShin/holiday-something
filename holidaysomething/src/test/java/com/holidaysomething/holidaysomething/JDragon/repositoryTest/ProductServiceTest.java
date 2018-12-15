package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {


    @Autowired
    private AdminProductService adminProductService;

    @Test
    public void 상품서비스에서등록하기테스트() {
        Product p = new Product();
        ProductDetail pd = new ProductDetail();
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
        p.setProductCategory(pc);

        String description = "이거 방탄유리야!!!!!!!!";

        Product insertedProduct = adminProductService.productRegister(p, description, pc.getId());

        System.out.println("================================");
        System.out.println("상품 id : " + insertedProduct.getId());
        System.out.println("상품 name : " + insertedProduct.getName());
        System.out
                .println("상품 description : " + insertedProduct.getProductDetail().getDescription());
        System.out.println("상품 category id : " + insertedProduct.getProductCategory().getId());
        System.out.println("상품 category name : " + insertedProduct.getProductCategory().getName());


    }


}
