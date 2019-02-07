package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.service.product.ProductDetailService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        // 해당 상품에 포함되는 옵션들
        modelMap.addAttribute("productOptions", productOptionService.getProductOptionsByProductId(productId));
        // 해당 카테고리 판매량 Top 5 상품
        Page<Product> bestFiveProducts = productService.getBestFiveProduct(categoryId, productId);
        modelMap.addAttribute("bestProducts", bestFiveProducts);

        // Top 5 상품의 메인 이미지(1L)
//        List<ProductImage> productImages = productImageService.getBestProductImages(bestFiveProducts, 1L);

        // 해당 상품의 MainImage(1L) & SubImage(2L)
        modelMap.addAttribute("mainImage", productImageService.getProductImageMain(productId, 1L));
        modelMap.addAttribute("subImages", productImageService.getProductImageSub(productId, 2L));

        return "/user/product/detail";
    }
}
