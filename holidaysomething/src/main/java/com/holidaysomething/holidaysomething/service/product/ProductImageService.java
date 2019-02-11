package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductImageService {
    ProductImage getProductImage(String storedFileName);

    List<ProductImage> getProductImageSub(Long productId, Long categorySub);

    ProductImage getProductImageMain(Long productId, Long categoryMain);

//    List<ProductImage> getBestProductImageMain(Page<Product> bestFiveProducts, Long category);
}
