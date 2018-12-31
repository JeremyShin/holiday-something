package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOptionCommand;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/product/option")
@Slf4j
@RequiredArgsConstructor
public class AdminProductOptionController {

  private final ProductService productService;
  private final ProductOptionService productOptionService;

  @GetMapping
  public String productOptions(ModelMap modelMap,
      @RequestParam(value = "page", defaultValue = "1") int page) {
    int productOptionListSize = productOptionService.getAllProductOptions().size();
    modelMap.addAttribute("productOptionListSize", productOptionListSize);

    Pageable pageable = PageRequest.of(page - 1, 10);
    Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptions", productOptions);

    return "admin/product/option";
  }

  @GetMapping("/bundle")
  public String productOptionBundle(ModelMap modelMap,
      @RequestParam("size") int size) {
    List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
    int productOptionListSize = productOptionList.size();
    modelMap.addAttribute("productOptionList", productOptionList);
    modelMap.addAttribute("productOptionListSize", productOptionListSize);

    Pageable pageable = PageRequest.of(0, size);
    Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptions", productOptions);

    return "admin/product/option";
  }

  @PostMapping("/delete")
  public String deleteProductOption(@RequestParam("productOptionId") String[] productOptionIds) {

    // check된 row를 `productOptions` 테이블에서 삭제
    for (String id : productOptionIds) {
      productOptionService.deleteProductOption(Long.parseLong(id));
      log.info(id + "번 productOptions 삭제 완료");
    }

    // 옵션 삭제 후 현재 페이지로 redirect
    return "redirect:/admin/product/option";
  }

  @GetMapping("/search")
  public String searchProductOption(
      ModelMap modelMap,
      @RequestParam("productOptionSearchField") String productOptionSearchField,
      @RequestParam("productOptionSearchValue") String productOptionSearchValue) {
    log.info("productOptionSearchField: " + productOptionSearchField);
    log.info("productOptionSearchValue: " + productOptionSearchValue);

    // `product_option`에서 productOptionSearchField가 productOptionSearchValue인 row를 검색
    // 검색된 결과를 페이징 처리하여 보여준다
    Page<ProductOption> productOptions = new PageImpl<>(new ArrayList<>());
    Pageable pageable = PageRequest.of(0, 10);

    if (productOptionSearchField.equals("name")) {
      productOptions = productOptionService
          .getAllProductOptionsByNamePage(productOptionSearchValue, pageable);
    } else if (productOptionSearchField.equals("description")) {
      productOptions = productOptionService
          .getAllProductOptionsByDescriptionPage(productOptionSearchValue, pageable);
    } else if (productOptionSearchField.equals("price")) {
      productOptions = productOptionService
          .getAllProductOptionsByPricePage(productOptionSearchValue, pageable);
    }
    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptionsSearchResult", productOptions);

    return "/admin/product/option";
  }

  /* 옵션 등록 */
  @GetMapping("/add")
  public String addProductOption(Model model) {
    // 모든 상품목록 가져오기
    List<Product> products = productService.getAllProducts();
    model.addAttribute("products", products);

    return "admin/product/option-add";
  }

  /* 옵션 등록 */
  @PostMapping("/add")
  public String addProductOption(
      @RequestParam(value = "productId", defaultValue = "") Long productId,
      ProductOptionCommand productOptionCommand) {
    List<ProductOption> productOptions = productOptionService
        .fromProductOptionCommandToProductOptionList(productOptionCommand);
    productOptionService.save(productOptions, productId);

    return "redirect:/admin/product/option";
  }

}
