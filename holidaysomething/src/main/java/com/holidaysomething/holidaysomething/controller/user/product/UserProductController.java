package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.security.MemberUserDetails;
import com.holidaysomething.holidaysomething.service.product.CartProductService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductListService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product")
public class UserProductController {

  private final ProductListService productListService;
  private final ProductOptionService productOptionService;
  private final ProductService productService;
  private final ProductImageService productImageService;
  private final CartProductService cartProductService;

  // 소분류 카테고리 눌렀을 때 조회돼야 하는 상품 리슷트!
  @GetMapping("/{categoryId}")
  public String productList(@PathVariable("categoryId") Long categoryId,
      @PageableDefault(size = 12, sort = "name", direction = Direction.ASC) Pageable pageable
      , ModelMap model) {

    if (categoryId == 0L) {
      return "redirect:/";
    }

    ProductListCategoryDto productListCategoryDto
        = productListService.productList(categoryId, pageable);

    Page<ProductListImageDto> productListImageDtos
        = productListCategoryDto.getProductListImageDtoPage();

    List<ProductCategory> categoryList = productListCategoryDto.getCategoryList();

    // 현재 카테고리
    model.addAttribute("categoryId", categoryId);

    // 상품 리스트
    model.addAttribute("productListImageDtos", productListImageDtos);

    // 카테고리 경로 표현.
    model.addAttribute("categoryList", categoryList);

    // 대분류 마다 다른 배너를 출력하기 위해.
    model.addAttribute("bigCategoryName", categoryList.get(1).getName());

    return "user/product/list";
  }

  @GetMapping("{categoryId}/{productId}")
  public String productDetail(@PathVariable("categoryId") Long categoryId,
      @PathVariable("productId") Long productId,
      @AuthenticationPrincipal MemberUserDetails userDetails,
      ModelMap modelMap) {
    // 로그인 유무 Check
    modelMap.addAttribute("loginCheck", userDetails != null);
    // 상품 그 자체
    modelMap.addAttribute("product", productService.getProduct(productId));
    // 해당 상품에 포함되는 옵션들
    modelMap.addAttribute("productOptions",
        productOptionService.getProductOptionsByProductId(productId));
    // 해당 상품의 MainImage(1L) & SubImage(2L)
    modelMap.addAttribute("mainImage", productImageService.getProductImageMain(productId, 1L));
    modelMap.addAttribute("subImages", productImageService.getProductImageSub(productId, 2L));

    return "user/product/detail";
  }
}