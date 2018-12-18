package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import java.util.List;

public interface ProductCategoryService {

  List<ProductCategory> getCategory(Long parentId);
}
