package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductCategoryDto;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    @Autowired
    AdminProductService adminProductService;


    @GetMapping
    public String product(){
        return "admin/product/product";
    }

    @GetMapping("/product_category")
    public String productCategory(){
        return "admin/product/product_category";
    }

    @GetMapping("/product_detail")
    public String productDetail(){
        return "admin/product/product_detail";
    }

    @GetMapping("/product_detail/register")
    public String productRegister(ModelMap model){
        List<ProductCategory> categories = adminProductService.productCategoryList();


        model.addAttribute("categories",categories);
        //model.put("categories", categories);
        return "admin/product/product_register";
    }

//    @ResponseBody
//    @GetMapping("/product_detail/register/lowcategories/{parentId}")
//    public Map<String,List<ProductCategory>> getLowLevelCategories(@PathVariable("parentId") Long parentId){
//        List<ProductCategory> categories = adminProductService.productLowLevelCategoryList(parentId);
//        System.out.println("===================  " + categories.size());
//
//        Map< String , List<ProductCategory>> map = new HashMap<>();
//
//        map.put("categories",categories);
//        System.out.println("==============================" + map);
//
//        return map;
//    }

    @ResponseBody
    @GetMapping("/product_detail/register/lowcategories/{parentId}")
    public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId){
        List<ProductCategory> categories = adminProductService.productLowLevelCategoryList(parentId);
        System.out.println("===================  " + categories.size());
        return categories;
    }


}
