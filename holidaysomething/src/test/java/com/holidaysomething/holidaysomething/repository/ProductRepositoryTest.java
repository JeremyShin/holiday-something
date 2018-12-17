package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    // admin : search by name test
    @Test
    public void 이름포함된Product구하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Product> products = productRepository.findbyProductNameContaining("아이코닉", pageable);
        System.out.println("-----");
        System.out.println(products.getTotalElements());
        System.out.println(products.getTotalPages());
        System.out.println("-----");

        for(Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void 중분류Product검색하기() throws Exception {
        List<ProductCategory> productCategories = productCategoryRepository.findByProductMiddleCategoryContaining(1L);

        System.out.println("---");
        System.out.println("---");
        for(ProductCategory productCategory : productCategories) {
            if(productCategory.getParentProductCategory() != null){
                System.out.println(productCategory.getId()+", "+productCategory.getParentProductCategory().getId());
            } else {
                System.out.println(productCategory.getId());
            }
        }
        Assert.assertNotNull(productCategories);
        System.out.println(productCategories.size());
        System.out.println("---");
        System.out.println("---");

    }

    @Test
    public void 대분류Product검색하기() throws Exception {
        List<ProductCategory> productCategories = productCategoryRepository.findByProductBigCategoryContaining();

        System.out.println("----");
        System.out.println("----");
        for(ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.getName());
        }
        System.out.println("---");
        System.out.println("---");

    }

    @Test
    public void 테스트() throws Exception {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        for(ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.getId()+", "+productCategory.getParentProductCategory().toString());
        }

//        for(ProductCategory productCategory : productCategories) {
//            System.out.println(productCategory.getId()+", "+productCategory.getParentProductCategory().getName());
//        }


    }
}
