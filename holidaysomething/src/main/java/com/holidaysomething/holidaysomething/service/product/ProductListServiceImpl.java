package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
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


  @Override
  public Page<ProductListImageDto> productList(long categoryId, Pageable pageable) {
    return productRepository.findProductsImageByCategoryId(categoryId, pageable);
  }


}
