package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import java.util.List;

public interface ProductImageService {

  ProductImage getProductImage(String storedFileName);

  List<ProductImage> getProductImageSub(Long productId, Long categorySub);

  ProductImage getProductImageMain(Long productId, Long categoryMain);
}
