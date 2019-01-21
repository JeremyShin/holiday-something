package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductAddDto;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.service.fileupload.ImageStreamService;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

import com.holidaysomething.holidaysomething.service.product.ProductService;
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

  /**
   * @author : Junhyeong Kim
   * @description : 이미지 업로드
   */
  @PostMapping("/image-files/api")
  public String handleFileUpload(@RequestParam("fname") String fname,
                                 @RequestParam("data") MultipartFile multipartFile) {
    String saveFileName = imageStreamService.save(multipartFile);

    return "/admin/product/image-files/" + saveFileName;
  }

  @PostMapping("/add/api")
  public void productAddPost(
          @Valid @RequestBody ProductAddDto productAddDto,
          BindingResult bindingResult, ModelMap model) {

    if (bindingResult.hasErrors()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        log.info(error.getDefaultMessage());
        //model.addAttribute("product", product);
      }
//      return "admin/product/add";
    } else {
      //등록작업

      System.out.println("등록작업을 시작합니다");
      System.out.println("등록작업을 시작합니다");
      System.out.println("등록작업을 시작합니다");
      System.out.println("등록작업을 시작합니다");
      System.out.println("등록작업을 시작합니다");
      System.out.println("등록작업을 시작합니다z");

      productAddDto.setRegDate(LocalDateTime.now());

      productAddService.productRegister(productAddDto);
    }
  }
}