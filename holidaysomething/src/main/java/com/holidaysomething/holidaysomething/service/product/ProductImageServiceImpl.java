package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductImageRepository;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Override
    public ProductImage getProductImage(String storedFileName) {
        return productImageRepository.findByStoredFileName(storedFileName);
    }

    @Override
    public List<ProductImage> getProductImageSub(Long productId, Long categorySub) {
        return productImageRepository.findByProductIdAndCategory(productId, categorySub);
    }

    @Override
    public ProductImage getProductImageMain(Long productId, Long categoryMain) {
        return productImageRepository.findProductByProductIdAndCategory(productId, categoryMain);
    }

//    @Override
//    public List<ProductImage> getBestProductImageMain(Page<Product> bestFiveProducts, Long category) {
//        List<ProductImage> bestProductImage = new ArrayList<>();
//
//        for (Product bestProduct : bestFiveProducts) {
//            bestProductImage.add(productImageRepository.findProductByProductIdAndCategory(bestProduct.getId(), category));
//        }
//
//        return bestProductImage;
//    }
}
