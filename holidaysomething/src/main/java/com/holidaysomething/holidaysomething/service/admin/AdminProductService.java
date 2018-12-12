package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductCategoryDto;

import java.util.List;

public interface AdminProductService {

    public List<ProductCategory> productCategoryList();

    public List<ProductCategory> productLowLevelCategoryList(Long parentId);
}
