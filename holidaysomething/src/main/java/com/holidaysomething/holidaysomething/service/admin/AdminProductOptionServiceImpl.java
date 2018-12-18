package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminProductOptionServiceImpl implements AdminProductOptionService {

  private ProductOptionRepository productOptionRepository;

  public AdminProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
    this.productOptionRepository = productOptionRepository;
  }

  @Override
  @Transactional
  public List<ProductOption> productOptions() {
    List<ProductOption> productOptions = productOptionRepository.findAll();
    return productOptions;
  }
}
