package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductService productService;

    public AdminProductController (ProductService productService){
        this.productService = productService;
    }

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

    @GetMapping("/product_list")
    public String productList(ModelMap modelMap, @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC , size = 10)Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        modelMap.addAttribute("products", products);
        return "admin/product/product_list";
    }
}
