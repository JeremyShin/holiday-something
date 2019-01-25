//package com.holidaysomething.holidaysomething.repository;
//
//import com.holidaysomething.holidaysomething.domain.ProductImage;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ProductImageRepositoryTest {
//
//    @Autowired
//    private ProductImageRepository productImageRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void 이미지불러오기() throws Exception {
//        List<ProductImage> mainImage = productImageRepository.findByProductIdAndCategory(31L, 1L);
//        List<ProductImage> subImages = productImageRepository.findByProductIdAndCategory(31L, 2L);
//
//        int mainImageCount = mainImage.size();
//        Assert.assertEquals(1, mainImageCount);
//
//        int subImageCount = subImages.size();
//        Assert.assertEquals(2, subImageCount);
//    }
//}