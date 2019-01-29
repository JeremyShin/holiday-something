package com.holidaysomething.holidaysomething.controller.user.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.dto.ProductListCategoryDto;
import com.holidaysomething.holidaysomething.dto.ProductListImageDto;
import com.holidaysomething.holidaysomething.service.product.ProductListService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 25/01/2019.
 * @project holidaysomething
 * @description
 */
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class UserProductListController {

  private final ProductListService productListService;

  // 소분류 카테고리 눌렀을 때 조회돼야 하는 상품 리슷트!
  @GetMapping("/{categoryId}")
  public String productList(@PathVariable("categoryId") Long categoryId,
      @PageableDefault(size = 10, sort = "name", direction = Direction.ASC) Pageable pageable
      , ModelMap model) {

    if (categoryId == 0l) {
      log.info("================== categoryId 가 0이다.main 으로 간다.");
      return "redirect:/";
    }

//    Page<ProductListImageDto> productListImageDtos = productListService
//        .productList(categoryId, pageable);

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


}
