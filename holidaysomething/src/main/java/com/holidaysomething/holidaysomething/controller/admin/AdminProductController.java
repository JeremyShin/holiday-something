package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductService productService;

    public AdminProductController(ProductService productService) {
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

//    @GetMapping("/product_search")
//    public String productSearch(ModelMap modelMap) {
//
//        List<ProductCategory> productCategories =  productService.findByProductBigCategoryContaining();
//        modelMap.addAttribute("bigCategory", productCategories);
//
//        return "admin/product/product_search";
//    }

    @PostMapping("/product_search/result")
    public String searchResult(ModelMap modelMap,
                                     @RequestParam(value = "productName") String product,
                                     @RequestParam(value = "page", defaultValue = "0") int start) {

        Pageable pageable = PageRequest.of(start, start+5);

        // 제품명으로 검색하기
        Page<Product> products = productService.findByProductNameContaining(product, pageable);
        modelMap.addAttribute("productName", products);
        modelMap.addAttribute("totalPages", products.getTotalPages());
        modelMap.addAttribute("presentPage", products.getNumber()+1);

        return "/admin/product/product_search_result";
    }
}
