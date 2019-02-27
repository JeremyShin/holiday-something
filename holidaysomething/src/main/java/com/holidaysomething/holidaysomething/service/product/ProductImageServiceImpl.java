package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

  private final ProductImageRepository productImageRepository;

  @Override
  @Transactional(readOnly = true)
  public ProductImage getProductImage(String storedFileName) {
    return productImageRepository.findByStoredFileName(storedFileName);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductImage> getProductImageSub(Long productId, Long categorySub) {
    return productImageRepository.findByProductIdAndCategory(productId, categorySub);
  }

  @Override
  @Transactional(readOnly = true)
  public ProductImage getProductImageMain(Long productId, Long categoryMain) {
    return productImageRepository.findProductByProductIdAndCategory(productId, categoryMain);
  }
}
