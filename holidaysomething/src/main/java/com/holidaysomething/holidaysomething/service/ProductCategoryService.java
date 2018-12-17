package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getCategory(Long parentId);
}
