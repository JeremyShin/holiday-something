package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductImage;

import java.util.List;

public interface ProductImageService {
    ProductImage getProductImage(String storedFileName);

    List<ProductImage> getProductImages(Long productId, Long categorySub);
}
