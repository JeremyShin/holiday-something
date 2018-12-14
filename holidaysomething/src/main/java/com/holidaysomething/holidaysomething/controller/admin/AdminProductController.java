package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductDto;
import com.holidaysomething.holidaysomething.service.admin.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    // 대분류 불러오기.
    @GetMapping("/product_detail/register")
    public String productRegister(ModelMap model){
        List<ProductCategory> categories = adminProductService.productCategoryList(0l);

        Product product = new Product();
        ProductDetail productDetail = new ProductDetail();
        ProductCategory productCategory = new ProductCategory();
        ProductDto productDto = new ProductDto();

        model.addAttribute("categories",categories);
//        model.addAttribute("product",product);
//        model.addAttribute("productDetail",productDetail);
//        model.addAttribute("productCategory",productCategory);
        model.addAttribute("productDto",productDto);


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

    // 중소분류 읽어오기.
    @ResponseBody
    @GetMapping("/product_detail/register/lowcategories/{parentId}")
    public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId){
        List<ProductCategory> categories = adminProductService.productCategoryList(parentId);
        System.out.println("===================  " + categories.size());
        return categories;
    }



    // 상품등록
    @PostMapping("/product_detail/register")
    public String registerProduct(@ModelAttribute(value="productDto") ProductDto productDto) {

        String description = productDto.getProductDescription();
        Long parentId = productDto.getProductCategoryId();

        Product product = adminProductService.productDtoToProduct(productDto);

        product = adminProductService.productRegister(product,description,parentId);

        return "redirect:/admin/product/product_detail/register";


    }

//    @PostMapping("/product_detail/register")
//    public String registerProduct(@ModelAttribute(value="Product") Product product,
//                                  BindingResult errors,
//                                  @ModelAttribute(value="ProductDetail") ProductDetail productDetail,
//                                  @ModelAttribute(value="productCategory") ProductCategory productCategory) {
//        String name = product.getName();
//        System.out.println("============================ :" + name);
//
//        String description = productDetail.getDescription();
//        System.out.println("============================ :" + description);
//
//        Long categoryId = productCategory.getId();
//        String categoryName = productCategory.getName();
//        System.out.println("====================== categoryId:  " + categoryId);
//        System.out.println("====================== categoryName:  " + categoryName);
//
//
////        Long productId = adminProductService.productRegister(product,productDetail);
////        System.out.println("======================= : " + productId);
//
//
//        return "redirect:/admin/product/product_detail/register";
//    }

}
