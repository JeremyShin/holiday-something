package com.holidaysomething.holidaysomething.controller.admin.product;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.dto.ProductAddDto;
import com.holidaysomething.holidaysomething.service.fileupload.ImageStreamService;
import com.holidaysomething.holidaysomething.service.product.ProductAddService;
import com.holidaysomething.holidaysomething.service.product.ProductImageService;
import com.holidaysomething.holidaysomething.service.product.ProductOptionService;
import com.holidaysomething.holidaysomething.service.product.ProductService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductController {

  private final ProductService productService;
  private final ProductOptionService productOptionService;
  private final ProductAddService productAddService;
  private final ProductImageService productImageService;
  private final ImageStreamService imageStreamService;

  @GetMapping
  public String product() {
    return "admin/product/index";
  }

  @GetMapping("/category")
  public String productCategory() {
    return "admin/product/category";
  }

  /**
   * @author JDragon
   * 상품 등록하기 페이지
   */
  @GetMapping("/add")
  public String productAdd(ModelMap model) {
    ProductAddDto product = new ProductAddDto();
    model.addAttribute("product", product);

    return "admin/product/add";
  }

  @GetMapping("/update")
  public String productUpdate(ModelMap model, @RequestParam("id") Long productId) {

    // TODO: 이미지와 설명을 한번에 읽어오는 쿼리문을 만들어야 한다. 미구현.
    Product product = productService.getProduct(productId);
    String description = product.getProductDetail().getDescription();

    Iterator<ProductImage> itr = product.getProductImages().iterator();
    ProductImage mainImage = null;
    List<ProductImage> subImages = new ArrayList<>();

    while (itr.hasNext()) {
      ProductImage temp = itr.next();
      if (temp.getCategory() == 1) {
        mainImage = temp;
      } else {
        subImages.add(temp);
      }
    }

    model.addAttribute("product", product);
    model.addAttribute("description", description);
    model.addAttribute("mainImage", mainImage);
    model.addAttribute("subImages", subImages);

    return "admin/product/update";
  }

  /**
   * @param bindingResult (반드시 @Valid 객체 뒤에 위치해야 한다.)
   * The BindingResult must come right after the model object that is validated
   * or else Spring will fail to validate the object and throw an exception.
   * @author JDragon
   */
  @PostMapping("/add")
  public String productAddPost(
      @Valid @ModelAttribute(value = "product") ProductAddDto productAddDto,
      BindingResult bindingResult,
      MultipartFile mainImage, MultipartFile[] subImages) {

    if (bindingResult.hasErrors()) {
      for (ObjectError error : bindingResult.getAllErrors()) {
        log.info(error.getDefaultMessage());
      }
      return "admin/product/add";
    }
    else {
      productAddDto.setRegDate(LocalDateTime.now());
      Product savedProduct = productAddService.productRegister(productAddDto);

      if (!mainImage.isEmpty()) {
        imageStreamService.save(mainImage, savedProduct.getProductDetail().getId());
      }

      for (MultipartFile multipartFile : subImages) {
        if (!multipartFile.isEmpty()) {
          imageStreamService.save(multipartFile, savedProduct.getProductDetail().getId());
        }
      }

      Integer optionQuantity = productAddDto.getQuantity();
      ProductOption productOption = new ProductOption();
      productOption.setName("기본값");
      productOption.setProduct(savedProduct);
      productOption.setQuantity(optionQuantity);
      productOption.setPrice(0);

      productOptionService.save(productOption);

      return "redirect:/admin/product/add";
    }
  }


  /**
   * Tui editor 사용 시 이미지 미리보기 기능
   */
  @GetMapping("/image-files/{fileName}")
  @ResponseBody
  public void handleFileUpload(@PathVariable("fileName") String fileName,
      HttpServletResponse response) {

    ProductImage productImage = productImageService.getProductImage(fileName);

    response.setContentLengthLong(productImage.getSize());
    response.setContentType(productImage.getFileType());

    try {
      imageStreamService.readAndWrite(productImage.getPath() + productImage.getStoredFileName(),
          response.getOutputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 상품 검색 페이지로 이동
   */
  @GetMapping("/search")
  public String productSearch(ModelMap modelMap,
      @RequestParam(value = "page", defaultValue = "1") int page) {

    // 대분류를 불러온다
    List<ProductCategory> largeCategories = productAddService.productCategoryList(0L);
    modelMap.addAttribute("largeCategories", largeCategories);

    // 모든 상품 리스트를 불러온다(페이지)
    Pageable pageable = PageRequest.of(page - 1, 10);
    Page<Product> allProductList = productAddService.getAllProducts(pageable);
    int productPageCount = allProductList.getTotalPages();

    modelMap.addAttribute("allProductList", allProductList);
    modelMap.addAttribute("productPageCount", productPageCount);

    return "admin/product/search";
  }

  /**
   * 상품 검색 결과
   */
  @PostMapping("/search")
  public String productSearchPost(ModelMap modelMap,
      @RequestParam(value = "productSearchClassification", required = false) String searchClassificationValue,
      @RequestParam(value = "productSearchClassificationInput", required = false) String searchClassificationInput,
      @RequestParam(value = "productLargeCategoryId", required = false) Long largeId,
      @RequestParam(value = "productMiddleCategoryId", required = false) Long middleId,
      @RequestParam(value = "productSmallCategoryId", required = false) Long smallId,
      @RequestParam(value = "productDate", required = false) String dateValue,
      @RequestParam(value = "productRegDateStart", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String startDateSelect,
      @RequestParam(value = "productRegDateEnd", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String endDateSelect) {

    // 모든 상품 리스트를 불러온다(페이지)
    // TODO: 검색 결과도 페이징 처리 필요
    Pageable pageable = PageRequest.of(0, 10);

    Page<Product> productPage = productService
        .findProducts(searchClassificationValue, searchClassificationInput,
            largeId, middleId, smallId, dateValue, startDateSelect, endDateSelect, pageable);
    int productPageCount = productPage.getTotalPages();

    modelMap.addAttribute("allProductList", productPage);
    modelMap.addAttribute("productPageCount", productPageCount);

    return "admin/product/search";
  }

  /**
   * @author JDragon
   * 상품 상세 정보
   */
  @GetMapping("/{productId}")
  public String productDetail(@PathVariable("productId") Long productId,
      @RequestParam(required = false, value = "optionPage") Optional<Integer> pageNum,
      ModelMap model) {

    // 상품id 로 상품 정보 가져오기.
    Product product = productService.getProduct(productId);
    model.addAttribute("product", product);

    // html 파일에서 페이징 처리 한 부분은 1로 시작하고
    // Pageable 에서 페이지는 0 부터 시작하므로 1을 빼줘야한다.
    Pageable pageable;

    if (pageNum.isPresent()) {
      if (pageNum.get().equals(0)) {
        // 주소창에 admin/product/1?optionPage=0 을 입력했을시
        // 정상 처리하는 로직
        pageable = PageRequest.of(0, 5);
      } else {
        pageable = PageRequest.of(pageNum.map(integer -> integer - 1).orElse(0), 5);
      }
    } else {
      pageable = PageRequest.of(0, 5);
    }

    //Page<ProductOption> productOptions =
    Page<ProductOption> productOptions = productOptionService
        .getProductOptionsByProductId(productId, pageable);

    ProductImage productImageMain = productImageService
        .getProductImageMain(productId, 1L);

    model.addAttribute("productOptions", productOptions);
    model.addAttribute("productImageMain",
        productImageMain.getPath() + productImageMain.getStoredFileName());

    int pageCount = productOptions.getTotalPages();
    model.addAttribute("pageCount", pageCount);
    model.addAttribute("productId", productId);

    return "admin/product/detail";
  }
}
