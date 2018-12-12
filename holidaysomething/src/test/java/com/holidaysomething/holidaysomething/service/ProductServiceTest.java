package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    Pageable pageable = PageRequest.of(0, 5);

    @Test
    public  void productName검색() {
        Page<Product> products = productService.findByProductNameContaining("아이코닉", pageable);
        System.out.println("---");
        for(Product product : products) {
            System.out.println(product.getName());
        }

        System.out.println(products.getTotalElements());
        System.out.println(products.getTotalPages());
    }
}
