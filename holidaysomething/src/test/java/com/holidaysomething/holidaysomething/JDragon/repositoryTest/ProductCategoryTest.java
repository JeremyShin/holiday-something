package com.holidaysomething.holidaysomething.JDragon.repositoryTest;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductCategoryTest {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void 카테고리전체읽어와버리기() {
        List<ProductCategory> categories = productCategoryRepository.findAll();
        for(ProductCategory pc : categories) {
            System.out.println(pc.getName());
        }

    }

    @Test
    public void 대분류카테고리만읽어와버리기() {
        List<ProductCategory> categories = productCategoryRepository.findLevelOne();
        for(ProductCategory pc : categories) {
            System.out.println(pc.getName());
        }
    }

    @Test
    public void 낮은분류카테고리읽어오기() {
        List<ProductCategory> categories = productCategoryRepository.findLowLevel(1l);
        for(ProductCategory pc : categories) {
            System.out.println(pc.getName());
        }
    }
}
