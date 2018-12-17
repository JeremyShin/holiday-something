package com.holidaysomething.holidaysomething.service;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getCategory(Long parentId) {
        return productCategoryRepository.findByParentId(parentId);
    }
}
