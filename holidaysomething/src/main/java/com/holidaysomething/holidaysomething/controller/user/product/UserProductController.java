package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoCommand;
import com.holidaysomething.holidaysomething.dto.ProductOrderInfoDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.product.CartProductService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product")
public class UserProductController {

    private final ProductOptionService productOptionService;
    private final ProductService productService;
    private final ProductImageService productImageService;
    private final CartProductService cartProductService;

    @GetMapping("{categoryId}/{productId}")
    public String productDetail(@PathVariable("categoryId") Long categoryId,
                                @PathVariable("productId") Long productId,
                                @AuthenticationPrincipal MemberUserDetails userDetails,
                                ModelMap modelMap) {
        // 로그인 유무 Check
        modelMap.addAttribute("loginCheck", userDetails != null);
        // 상품 그 자체
        modelMap.addAttribute("product", productService.getProduct(categoryId, productId));
        // 해당 상품에 포함되는 옵션들
        modelMap.addAttribute("productOptions", productOptionService.getProductOptionsByProductId(productId));
        // 해당 상품의 MainImage(1L) & SubImage(2L)
        modelMap.addAttribute("mainImage", productImageService.getProductImageMain(productId, 1L));
        modelMap.addAttribute("subImages", productImageService.getProductImageSub(productId, 2L));

        return "/user/product/detail";
    }

    @PostMapping("/shoppingbag")
    public String cart(@AuthenticationPrincipal MemberUserDetails userDetails,
                       ProductOrderInfoCommand poc) {

        List<ProductOrderInfoDto> productOrderInfoDtos = poc.getProductOrderInfoDtos();

        for(ProductOrderInfoDto productOrderInfoDto : productOrderInfoDtos) {
            if(productOrderInfoDto.getProductId() != null
                    && productOrderInfoDto.getOptionId() != null
                    && productOrderInfoDto.getQuantity() != null) {
                cartProductService.save(productOrderInfoDto, userDetails.getId());
            }
        }

//        return "redirect:/";
        return "redirect:/user/cart";
    }
}
