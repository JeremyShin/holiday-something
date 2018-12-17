package com.holidaysomething.holidaysomething.service.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductDto;

import java.util.List;

public interface AdminProductService {

//    // 상품 대분류 카테고리 읽어오기야!
//    public List<ProductCategory> productCategoryList();

    // 상품 중,소분류 카테고리 읽어오기야!
    public List<ProductCategory> productCategoryList(Long parentId);


    // 상품 등록하기 전에 DTO를 Domain 객체로 만들어주깅
    public Product productDtoToProduct(ProductDto productDto);


    // 상품 등록 하기야!! (상품, 상품_디테일 테이블 두개 insert)
    public Product productRegister(Product product, String description, Long parentCategoryId);


}
