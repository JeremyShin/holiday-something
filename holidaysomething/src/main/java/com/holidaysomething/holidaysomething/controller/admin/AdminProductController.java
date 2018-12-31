package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.Search;
import com.holidaysomething.holidaysomething.dto.productOptionDto;
import com.holidaysomething.holidaysomething.service.ProductOptionService;
import com.holidaysomething.holidaysomething.service.ProductService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductOptionService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductRegisterService;
import com.holidaysomething.holidaysomething.util.FileUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/product")
@Slf4j
@RequiredArgsConstructor
public class AdminProductController {

  private final ProductService productService;
  private final ProductOptionService productOptionService;
  private final AdminProductRegisterService adminProductRegisterService;
  private final AdminProductOptionService adminProductOptionService;
  private final FileUtil fileUtil;

  @GetMapping
  public String product() {
    return "admin/product/product";
  }

  @GetMapping("/product_category")
  public String productCategory() {
    return "admin/product/product_category";
  }

  @GetMapping("/product_detail")
  public String productDetail(ModelMap modelMap,
      @RequestParam(value = "page", defaultValue = "1") int page) {

    int productOptionListSize = productOptionService.getAllProductOptions().size();
    modelMap.addAttribute("productOptionListSize", productOptionListSize);

    Pageable pageable = PageRequest.of(page - 1, 10);
    Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptions", productOptions);

    return "admin/product/product_detail";
  }

  @GetMapping("/product_detail/bundle")
  public String productDetailBundle(ModelMap modelMap,
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

    return "admin/product/product_detail";
  }

  // 대분류 불러오기. 중소분류 읽어오기는 RestController
  @GetMapping("/product_detail/register")
  public String productRegister(ModelMap model) {
    List<ProductCategory> categories = adminProductRegisterService.productCategoryList(0l);
    Product product = new Product();
    model.addAttribute("categories", categories);
    model.addAttribute("product", product);
    return "admin/product/product_register";
  }


  // 상품등록 , date1 : 제조일  ,  date2 : 출시일.
  @PostMapping("/product_detail/register")
  public String registerProduct(@ModelAttribute(value = "product") Product product,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date1,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date2,
      BindingResult bindingResult) {

    /*
     * if(bindingResult.hasErrors) {
     *   return "/admin/product/product_detail/register";
     * }else{
     *   등록작업
     *   return "rediret";
     * }
     */
    // productDto 로 날짜들을 가져올때... 타입이 맞지 않는다고 오류가 난다
    // 뷰에서 input으로 데이터를 보낼때 String으로 보내고. 컨트롤러에선 LocalDateTime으로 받아야하니
    // 문제가 생기는거같다. 그래서 일단은 날짜 받는부분은 따로 처리했다.
    // 아니다. 계속 null 값만 받아와서. 그렇다.

    String description = product.getProductDetail().getDescription();
    log.info("================ description : " + description);

    product.setManufactureDate(date1);
    product.setReleaseDate(date2);
    product.setRegDate(LocalDateTime.now());

//    Product product = adminProductRegisterService.productDtoToProduct(productDto);

    product = adminProductRegisterService.productRegister(product);

    return "redirect:/admin/product/product_detail/register";


  }

  @GetMapping("/product_list")
  public String productList(
      @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable,
      @ModelAttribute("search") Search search, ModelMap modelMap) {
    Page<Product> products = productService.findProductAllOrSearch(search, pageable);

    modelMap.addAttribute("products", products);

    return "admin/product/product_list";
  }

  @GetMapping("/product_image")
  public String productImage() {
    return "admin/product/product_image";
  }


  @PostMapping("/product_image")
  public String productImageUpload(@RequestParam("file") MultipartFile file,
      ModelMap modelMap,
      HttpSession session,
      HttpServletRequest request) {

    ProductImage productImage = fileUtil.handleFileStream(request, session, file);
    productService.saveProductImage(productImage);
    return "redirect:/admin/product/product_list";
  }

  @PostMapping("/delete/product_option")
  public String deleteProductOption(@RequestParam("productOptionId") String[] productOptionIds) {

    // check된 row를 `productOption` 테이블에서 삭제
    for (String id : productOptionIds) {
      productOptionService.deleteProductOption(Long.parseLong(id));
      log.info(id + "번 productOption 삭제 완료");
    }

    // 옵션 삭제 후 현재 페이지로 redirect
    return "redirect:/admin/product/product_detail";
  }

  @GetMapping("/get/name")
  public String getProductOptionsByName(
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

    return "/admin/product/product_detail";
  }

  @GetMapping("/product_search")
  public String productSearch(ModelMap modelMap,
      @RequestParam(value = "page", defaultValue = "1") int page) {

    // 대분류를 불러온다
    List<ProductCategory> largeCategories = adminProductRegisterService.productCategoryList(0L);
    modelMap.addAttribute("largeCategories", largeCategories);

    // 모든 상품 리스트를 불러온다(페이지)
    Pageable pageable = PageRequest.of(page - 1, 10);
    Page<Product> allProductList = adminProductRegisterService.getAllProducts(pageable);

    int productPageCount = allProductList.getTotalPages();
    modelMap.addAttribute("productPageCount", productPageCount);
    modelMap.addAttribute("allProductList", allProductList);

    return "admin/product/product_search";
  }

  @PostMapping("/product_search")
  public String productSearchPost(ModelMap modelMap,
      @RequestParam(value = "productSearchClassification", required=false) String searchClassificationValue,
      @RequestParam(value = "productSearchClassificationInput", required=false) String searchClassificationInput,
      @RequestParam(value = "productLargeCategoryId", required=false) Long largeId,
      @RequestParam(value = "productMiddleCategoryId", required=false) Long middleId,
      @RequestParam(value = "productSmallCategoryId", required=false) Long smallId,
      @RequestParam(value = "productSearchDate", required=false) String searchDateValue,
      @RequestParam(value = "productRegDateStart", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String startDateSelect,
      @RequestParam(value = "productRegDateEnd", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String endDateSelect) {
//    @RequestParam("productSearchDateInput") @DateTimeFormat(pattern="yyyy/MM/dd") Date productSearchDateInput) {
//    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date1,
//    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date2,

    log.info("searchClassificationValue: " + searchClassificationValue);
    log.info("searchClassificationInput: " + searchClassificationInput);
    log.info("largeId: " + largeId);
    log.info("middleId: " + middleId);
    log.info("smallId: " + smallId);
    log.info("searchDateValue: " + searchDateValue);
//    log.info("productSearchDateInput: " + productSearchDateInput);
    log.info("startDateSelect: " + startDateSelect);
    log.info("endDateSelect: " + endDateSelect);

    // 모든 상품 리스트를 불러온다(페이지)
    // TODO: 검색 결과도 페이징 처리 필요
    Pageable pageable = PageRequest.of(0, 10);

    // QueryDSL 적용
    Page<Product> productPage = productService.findProducts(searchClassificationValue, searchClassificationInput,
        largeId, middleId, smallId, searchDateValue, startDateSelect, endDateSelect, pageable);

//    Page<Product> productPage = new PageImpl<>(new ArrayList<>());

//    // '검색분류'로 검색
//    // 상품명 상품코드 판매가 제조공장 가격대체문구 배송비
//    if (productSearchClassificationInput != null) {
//      log.info("'검색분류'로 검색");
//      productPage = productService.findByProductClassification(productSearchClassificationValue,
//          productSearchClassificationInput, pageable);
//    }
//
//    // '상품분류'로 검색
//    //TODO: 대/중/소 하위까지 전부 찾아야 함
//    if (largeId != null) {
//      log.info("'상품분류'로 검색");
//      productPage = productService.findByProductCategory(largeId, pageable);
//    }
//
//    // '상품등록일'로 검색
//    if (!productStartDateSelect.equals("")) {
//      log.info("'상품등록일'로 검색");
//      LocalDateTime castDateStart = LocalDateTime.parse(productStartDateSelect);
//      LocalDateTime castDateEnd = LocalDateTime.parse(productEndDateSelect);
//      productPage = productService.findByProductRegdate(castDateStart, castDateEnd, pageable);
//    }

    modelMap.addAttribute("productPage", productPage);

    int productPageCount = productPage.getTotalPages();
    modelMap.addAttribute("productPageCount", productPageCount);
    modelMap.addAttribute("allProductList", productPage);

    return "admin/product/product_search";
  }

  /* 옵션 수정 */
  @PostMapping("/product_detail/option/modify")
  public String modifyOptionPost(@RequestBody productOptionDto productOptionDto) {
    log.info("POST 수정할 옵션의 이름은");
    log.info(productOptionDto.getName());
    return "redirect:/admin/product/product_detail";

  }

  /* 옵션 등록 */
  @GetMapping("/product_detail_add_option")
  public String addOption(Model model) {
    // 모든 상품목록 가져오기
    List<Product> products = productService.getAllProducts();
    model.addAttribute("products", products);

    return "admin/product/product_detail_add_option";
  }

  /* 옵션 등록 */
  @PostMapping("/product_detail_add_option")
  public String addProductOption(
      @RequestParam(value = "productId", defaultValue = "") Long productId,
      ProductOptionCommand productOptionCommand) {
    log.info("================== productId : " + productId);
    log.info("================== product_option_list : " +
        productOptionCommand.getProductOptions().size());
    log.info("============= proudctOptionCommand.name" +
        productOptionCommand.getProductOptions().get(0).getName());

    List<ProductOption> productOptions = adminProductOptionService
        .fromProductOptionCommandToProductOptionList(productOptionCommand);
    adminProductOptionService.save(productOptions, productId);

    return "redirect:/admin/product/product_detail_add_option";
  }

  @GetMapping("/{productId}")
  public String getProductDetail(@PathVariable("productId") Long productId,
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
        pageable = PageRequest.of(pageNum.isPresent() ? pageNum.get() - 1 : 0, 5);
      }
    } else {
      pageable = PageRequest.of(0, 5);
    }

    //Page<ProductOption> productOptions =
    Page<ProductOption> productOptions = productOptionService
        .getProductOptionsByProductId(productId, pageable);

    model.addAttribute("productOptions", productOptions);

    int pageCount = productOptions.getTotalPages();
    model.addAttribute("pageCount", pageCount);
    model.addAttribute("productId", productId);

    return "admin/product/product_detail_view";
  }

}
