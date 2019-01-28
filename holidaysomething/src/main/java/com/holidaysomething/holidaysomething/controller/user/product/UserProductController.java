package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.service.product.ProductDetailService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
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
    private final ProductOptionService productOptionService;
    private final ProductService productService;
    private final ProductImageService productImageService;

    @GetMapping("{categoryId}/{productId}")
    public String productDetail(@PathVariable("categoryId") Long categoryId,
                                @PathVariable("productId") Long productId,
                                ModelMap modelMap) {

        Product product = productService.getProduct(categoryId, productId);

        // 상품 그 자체
        modelMap.addAttribute("product", product);
        // 상품의 상세 설명 내용
        modelMap.addAttribute("productDescription", product.getProductDetail().getDescription());
        // 해당 상품에 포함되는 옵션들
        modelMap.addAttribute("productOptions", productOptionService.getProductOptionsByProductId(productId));
        // 해당 카테고리 판매량 Top 5
        modelMap.addAttribute("bestProducts", productService.getBestFiveProduct(categoryId, productId));
        // 해당 상품의 MainImage(1L) & SubImage(2L)
        modelMap.addAttribute("mainImage", productImageService.getProductImages(productId, 1L));
        modelMap.addAttribute("subImage", productImageService.getProductImages(productId, 2L));

        return "/user/product/detail";
    }
}
