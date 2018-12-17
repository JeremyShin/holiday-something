package com.holidaysomething.holidaysomething.Repository;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
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
public class productTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void 상품명순으로_모든_상품가져오기() throws Exception{
        List<Product> products = productRepository.findAlByOrderByName();
        for(Product product : products){
            System.out.println("상품명은" + product.getName() + "상품코드는 " + product.getCode());
        }

    }
}
