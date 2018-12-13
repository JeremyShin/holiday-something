package com.holidaysomething.holidaysomething.service.admin;


import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductCategoryDto;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import com.holidaysomething.holidaysomething.repository.ProductDetailRepository;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductCategory> productCategoryList() {

        List<ProductCategory> categories = productCategoryRepository.findAll();
        return categories;
    }

    @Override
    @Transactional
    public List<ProductCategory> productLowLevelCategoryList(Long parentId) {
        List<ProductCategory> categories = productCategoryRepository.findLowLevel(parentId);
        System.out.println("========================================" + categories.size());
//        for(ProductCategory pc : categories) {
//            System.out.println();
//            System.out.println("id : " + pc.getId());
//            System.out.println("id : " + pc.getName());
//        }
//        List<ProductCategoryDto> categoryDtos = new ArrayList<>();
//        for(ProductCategory pc : categories) {
//            ProductCategoryDto dto = new ProductCategoryDto();
//
//            dto.setId(pc.getId());
//            dto.setName(pc.getName());
//            dto.setOrders(pc.getOrders());
//            dto.setParentId(pc.getParentId());
//            categoryDtos.add(dto);
//        }

//        System.out.println("******************************* " + categoryDtos.size());
        return categories;
    }


    @Override
    @Transactional
    public Product productRegister(Product product, String description) {
        // 상품 등록하기 전에 상품내용먼저 등록한 후에 그 데이터를 상품에 set 해준다.
        ProductDetail pd = productDetailRepository.save(new ProductDetail(description));
        product.setProductDetail(pd);
        productRepository.save(product);

        return product;
    }


}
