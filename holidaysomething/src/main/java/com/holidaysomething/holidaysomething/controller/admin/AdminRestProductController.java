package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductRegisterService;
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
//@RequiredArgsConstructor
public class AdminRestProductController {

  private ProductOptionService productOptionService;
  private AdminProductRegisterService adminProductRegisterService;

  public AdminRestProductController(AdminProductRegisterService adminProductRegisterService, ProductOptionService productOptionService) {
    this.adminProductRegisterService = adminProductRegisterService;
    this.productOptionService = productOptionService;
  }



  @GetMapping("/subCategory/{largerId}")
  public List<ProductCategory> getSubCategories(@PathVariable("largerId") Long largerId) {
    log.info("========================================================");
    log.info("getSubCategories 진입, largerId: " + largerId);
    List<ProductCategory> categories = adminProductRegisterService.productCategoryList(largerId);
    log.info("========================================================");

    return categories;
  }

  // 중소분류 읽어오기.
  @GetMapping("/product_detail/register/lowcategories/{parentId}")
  public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId) {
    List<ProductCategory> categories = adminProductRegisterService.productCategoryList(parentId);
    return categories;
  }

  /* 옵션 수정 */
  @PostMapping("/product_detail/option/modify")
  public void modifyOptionPost(@RequestBody ProductOptionDto productOptionDto){
    log.info("POST 로 받을거에요 ");
    log.info(productOptionDto.getName());
    log.info(String.valueOf(productOptionDto.getId()));
    log.info(productOptionDto.getDescription());
    log.info(String.valueOf(productOptionDto.getPrice()));

    ProductOption productOption = productOptionService.getProductOption(productOptionDto.getId());

    productOption.setName(productOptionDto.getName());
    productOption.setPrice(productOptionDto.getPrice());
    productOption.setDescription(productOptionDto.getDescription());

    productOptionService.save(productOption);

    log.info("왜 리다이렉트를 못하니?");
    // 옵션 수정 후 현재 페이지로 redirect
//    return "redirect:/admin/product/product_detail";
  }

}
