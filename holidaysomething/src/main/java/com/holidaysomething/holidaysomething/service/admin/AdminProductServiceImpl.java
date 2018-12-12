package com.holidaysomething.holidaysomething.service.admin;


import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductCategoryDto;
import com.holidaysomething.holidaysomething.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

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


}
