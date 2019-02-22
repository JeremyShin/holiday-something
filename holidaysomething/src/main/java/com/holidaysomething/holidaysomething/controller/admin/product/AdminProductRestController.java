package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.*;
import com.holidaysomething.holidaysomething.dto.ProductAddDto;
import com.holidaysomething.holidaysomething.dto.ProductDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.service.fileupload.ImageStreamService;
import com.holidaysomething.holidaysomething.service.product.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductRestController {

  private final ProductOptionService productOptionService;
  private final ProductAddService productAddService;
  private final ImageStreamService imageStreamService;
  private final ProductDetailService productDetailService;

  /**
   * @author Gyumin Kim
   * 상품 등록시 대분류 읽어오기
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
  @PostMapping(path = "/option/modify",
              consumes = "application/json")
  public void productOptionModifyPost(@RequestBody ProductOptionDto productOptionDto) {
    ProductOption productOption = productOptionService.getProductOption(productOptionDto.getId());

    productOption.setName(productOptionDto.getName());
    productOption.setPrice(productOptionDto.getPrice());
    productOption.setDescription(productOptionDto.getDescription());

    productOptionService.save(productOption);

    // 옵션 수정 후 현재 페이지로 redirect
//    return "redirect:/admin/product/product_detail";
  }

   /**
   * @description : 이미지 업로드
   */
  @PostMapping("/image-files/api")
  public String handleFileUpload(@RequestParam("descriptionImage") MultipartFile multipartFile,
                                 Long productId) {
    String saveFileName = imageStreamService.save(multipartFile, productId);

    return "/admin/product/image-files/" + saveFileName;
  }
}