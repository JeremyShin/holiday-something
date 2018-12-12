package com.holidaysomething.holidaysomething.Repository;

import com.holidaysomething.holidaysomething.domain.Member;
import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class productTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void 카테고리별로_상품_가져오기() throws Exception{
        Product product = productRepository.findByProductCategoryIdOrderByName()
    }
}
