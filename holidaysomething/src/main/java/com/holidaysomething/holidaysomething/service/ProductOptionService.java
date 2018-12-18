package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductOptionService {

  List<ProductOption> getAllProductOptions();

  ProductOption getProductOption(Long id);

  void addProductOption(ProductOption productOption);

  void deleteProductOption(Long id);

  List<ProductOption> getAllProductOptionsByName(String name);

  Page<ProductOption> getAllProductOptionsPage(Pageable pageable);

  Page<ProductOption> getAllProductOptionsByNamePage(String name, Pageable pageable);

  Page<ProductOption> getAllProductOptionsByDescriptionPage(String productOptionSearchValue,
      Pageable pageable);

  Page<ProductOption> getAllProductOptionsByPricePage(String productOptionSearchValue,
      Pageable pageable);
}