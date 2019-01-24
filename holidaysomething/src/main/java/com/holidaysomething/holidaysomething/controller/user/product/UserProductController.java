package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.service.product.ProductDetailService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/product")
public class UserProductController {

    private final ProductDetailService productDetailService;
    private final ProductService productService;

    @GetMapping("/{productId}")
    public String productDetail(@PathVariable("productId") Long productId,
                                ModelMap modelMap) {

        Product product = productService.getProduct(productId);

        modelMap.addAttribute("productDescription", product.getProductDetail().getDescription());

        return "/user/product/detail";
    }
}
