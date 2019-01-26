package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;


  @Override
  public Page<ProductListImageDto> productList(long categoryId, Pageable pageable) {

    ProductCategory pc = productCategoryRepository.findProductCategoryById(categoryId);
    log.info("======= 카테고리 depth 는 " + pc.getDepth() + " 입니다.");

    if (pc.getDepth() == 1) {
      // 대분류.
      return productRepository.findProductsImageByCategoryId3(categoryId, pageable);
    } else if (pc.getDepth() == 2) {
      // 중분류.
      return productRepository.findProductsImageByCategoryId2(categoryId, pageable);
    } else {
      // 소분류.
      return productRepository.findProductsImageByCategoryId(categoryId, pageable);
    }
  }


}
