package com.holidaysomething.holidaysomething.service.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ProductCategory> getCategory(Long parentId) {
    return productCategoryRepository.findByParentId(parentId);
  }
}
