package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.service.admin.AdminProductRegisterService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/product")
@Slf4j
public class AdminRestProductController {

  private AdminProductRegisterService adminProductService;

  public AdminRestProductController(AdminProductRegisterService adminProductService) {
    this.adminProductService = adminProductService;
  }

  @GetMapping("/subCategory/{largerId}")
  public List<ProductCategory> getSubCategories(@PathVariable("largerId") Long largerId) {
    log.info("========================================================");
    log.info("getSubCategories 진입, largerId: " + largerId);
    List<ProductCategory> categories = adminProductService.productCategoryList(largerId);
    log.info("========================================================");

    return categories;
  }

  // 중소분류 읽어오기.
  @GetMapping("/product_detail/register/lowcategories/{parentId}")
  public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId) {
    List<ProductCategory> categories = adminProductService.productCategoryList(parentId);
    return categories;
  }

}
