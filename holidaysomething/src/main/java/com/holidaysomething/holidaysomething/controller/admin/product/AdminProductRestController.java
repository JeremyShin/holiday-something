package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductRestController {

  private final ProductOptionService productOptionService;
  private final ProductAddService productAddService;

  /*
   * @author : Gyumin Kim
   * @description : 상품 등록시 대분류 읽어오기
   */
  @GetMapping("/subcategory/{largerId}")
  public List<ProductCategory> productSubCategories(@PathVariable("largerId") Long largerId) {
    log.info("========================================================");
    log.info("productSubCategories 진입, largerId: " + largerId);
    List<ProductCategory> categories = productAddService.productCategoryList(largerId);
    log.info("========================================================");

    return categories;
  }

  /*
   * @author : JDragon
   * @description : 상품 등록시 대중소 카테고리 읽어오기
   */
  @GetMapping("/add/subcategories/{parentId}")
  public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId) {
    List<ProductCategory> categories = productAddService.productCategoryList(parentId);
    return categories;
  }

  /*
   * @author : Misun Joo
   * @description : 옵션 수정
   */
  @PostMapping("/option/modify")
  public void productOptionModifyPost(@RequestBody ProductOptionDto productOptionDto) {
    ProductOption productOption = productOptionService.getProductOption(productOptionDto.getId());

    productOption.setName(productOptionDto.getName());
    productOption.setPrice(productOptionDto.getPrice());
    productOption.setDescription(productOptionDto.getDescription());

    productOptionService.save(productOption);

    // 옵션 수정 후 현재 페이지로 redirect
//    return "redirect:/admin/product/product_detail";
  }
}