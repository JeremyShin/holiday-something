package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;

import java.util.List;

public interface AdminProductService {

    // 상품 대분류 카테고리 읽어오기야!
    public List<ProductCategory> productCategoryList();

    // 상품 중,소분류 카테고리 읽어오기야!
    public List<ProductCategory> productLowLevelCategoryList(Long parentId);

    // 상품 등록 하기야!! (상품, 상품_디테일 테이블 두개 insert)
    public Product productRegister(Product product, String description);


}
