package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductOptionService productOptionService;

    public AdminProductController(ProductOptionService productOptionService) {
        this.productOptionService = productOptionService;
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
    public String productDetail(ModelMap modelMap) {
        List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
        modelMap.addAttribute("productOptionList", productOptionList);
        modelMap.addAttribute("productOptionListSize", productOptionList.size());

        return "admin/product/product_detail";
    }
}
