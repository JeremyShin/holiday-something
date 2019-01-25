package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductImageRepository;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public List<ProductImage> getProductImages(Long productId, Long category) {
        return productImageRepository.findByProductIdAndCategory(productId, category);
    }
}
