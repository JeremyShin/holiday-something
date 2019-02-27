package com.holidaysomething.holidaysomething.controller.admin.api;

import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductDetail;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductDetailDto;
import com.holidaysomething.holidaysomething.dto.ProductOptionDto;
import com.holidaysomething.holidaysomething.service.fileupload.ImageStreamService;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductDetailService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("/admin/product")
@RequestMapping("/api/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductRestController {

  private final ProductOptionService productOptionService;
  private final ProductAddService productAddService;
  private final ImageStreamService imageStreamService;

  /**
   * @author Gyumin Kim
   * 상품 등록시 대분류 읽어오기
   */
  @GetMapping("/subcategory/{largerId}")
  public List<ProductCategory> productSubCategories(@PathVariable("largerId") Long largerId) {
    return productAddService.productCategoryList(largerId);
  }

  /**
   * @author Misun Joo
   * 옵션 수정
   */
  @PatchMapping(path = "/option",
      consumes = "application/json")
  public void productOptionModifyPost(@RequestBody ProductOptionDto productOptionDto) {
    ProductOption productOption = productOptionService.getProductOption(productOptionDto.getId());

    productOption.setName(productOptionDto.getName());
    productOption.setPrice(productOptionDto.getPrice());
    productOption.setDescription(productOptionDto.getDescription());

    productOptionService.save(productOption);
  }

   /**
   * 이미지 업로드
   */
  @PostMapping("/image-files")
  public String handleFileUpload(@RequestParam("descriptionImage") MultipartFile multipartFile,
      Long productId) {
    String saveFileName = imageStreamService.save(multipartFile, productId);

    return "/admin/product/image-files/" + saveFileName;
  }
}