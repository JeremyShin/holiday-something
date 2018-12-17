package com.holidaysomething.holidaysomething.controller.admin;


import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductCategoryDto;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminRestProductController {

  @Autowired
  AdminProductService adminProductService;

  @GetMapping("/hello")
  ResponseEntity<String> hello() {
    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
  }

//    @RequestMapping(value = "/admin/product/product_detail/register/lowcategories/{parentId}",method = RequestMethod.GET)
//    public ResponseEntity<List<ProductCategory>> getLowLevelCategories(@PathVariable("parentId") Long parentId){
//
//        ResponseEntity<List<ProductCategory>> entity = null;
//
//        try{
//            entity = new ResponseEntity<>(adminProductService.productLowLevelCategoryList(parentId), HttpStatus.OK);
//        } catch(Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//
//    }
}
