package com.holidaysomething.holidaysomething.repository;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void 카테고리로Product검색하기() throws Exception {
        List<ProductCategory> productCategories = productCategoryRepository.findByProductBigCategoryContaining();

        System.out.println("----");
        System.out.println("----");
        for(ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.getName());
        }
        System.out.println("---");
        System.out.println("---");

    }
}
