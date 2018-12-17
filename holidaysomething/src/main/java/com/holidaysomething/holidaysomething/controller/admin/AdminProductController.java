package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.repository.ProductOptionRepository;
import com.holidaysomething.holidaysomething.service.ProductCategoryService;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import com.holidaysomething.holidaysomething.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    private ProductOptionService productOptionService;
    private ProductService productService;

    @Autowired
  public AdminProductController(ProductOptionService productOptionService, ProductService productService) {
        this.productOptionService = productOptionService;
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

    /* 옵션 등록 */
    @GetMapping("/product_detail_add_option")
    public String addOption(Model model) {
        // 모든 상품목록 가져오기
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "admin/product/product_detail_add_option";
    }

    /* 옵션 등록 */
    @PostMapping("/product_detail_add_option")
    public String addProductOption(ProductOption productOption,
                                   @RequestParam(value = "productId", defaultValue = "") Long productId) {

            productOption.setProduct(productService.getProduct(productId));
            productOptionService.addProductOption(productOption);
//
//        for(ProductOption productOption : productOptions){
//            productOption.setProduct(productService.getProduct(productId));
//            productOptionService.addProductOption(productOption);
//        }

        return "admin/product/product_detail_add_option";
    }
}
