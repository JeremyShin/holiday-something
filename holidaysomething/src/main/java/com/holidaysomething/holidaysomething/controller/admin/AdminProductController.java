package com.holidaysomething.holidaysomething.controller.admin;

import com.holidaysomething.holidaysomething.domain.Product;
import com.holidaysomething.holidaysomething.domain.ProductCategory;
import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.domain.ProductOption;
import com.holidaysomething.holidaysomething.domain.ProductOptionCommand;
import com.holidaysomething.holidaysomething.dto.Search;

import com.holidaysomething.holidaysomething.service.ProductOptionService;
import com.holidaysomething.holidaysomething.service.ProductService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductOptionService;
import com.holidaysomething.holidaysomething.service.admin.AdminProductRegisterService;
import com.holidaysomething.holidaysomething.util.FileUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

  private ProductService productService;
  private ProductOptionService productOptionService;
  private AdminProductRegisterService adminProductRegisterService;
  private AdminProductOptionService adminProductOptionService;
  private FileUtil fileUtil;

  private static final Log log = LogFactory.getLog(AdminProductController.class);

  public AdminProductController(ProductOptionService productOptionService,
      ProductService productService, AdminProductRegisterService adminProductRegisterService,
      FileUtil fileUtil, AdminProductOptionService adminProductOptionService) {
    this.productOptionService = productOptionService;
    this.productService = productService;
    this.adminProductRegisterService = adminProductRegisterService;
    this.fileUtil = fileUtil;
    this.adminProductOptionService = adminProductOptionService;
  }

  @GetMapping
  public String product() {
    return "admin/product/product";
  }

  @GetMapping("/product_category")
  public String productCategory() {
    return "admin/product/product_category";
  }

  @GetMapping({"/product_detail", "/product_detail/{pageStart}"})
  public String productDetail(ModelMap modelMap, @PathVariable Optional<Integer> pageStart) {
    List<ProductOption> productOptionList = productOptionService.getAllProductOptions();
    int productOptionListSize = productOptionList.size();
    modelMap.addAttribute("productOptionList", productOptionList);
    modelMap.addAttribute("productOptionListSize", productOptionListSize);

    Pageable pageable = PageRequest.of(pageStart.isPresent() ? pageStart.get() - 1 : 0, 10);
    Page<ProductOption> productOptions = productOptionService.getAllProductOptionsPage(pageable);

    int pageCount = productOptions.getTotalPages();
    log.info("pageCount: " + pageCount);
    modelMap.addAttribute("pageCount", pageCount);
    modelMap.addAttribute("productOptions", productOptions);

    return "admin/product/product_detail";
  }

  @PostMapping("/product_detail")
  public String productDetailBundle(ModelMap modelMap,
      @RequestParam("productOptionBundleSize") int size) {
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

  // 대분류 불러오기.
  @GetMapping("/product_detail/register")
  public String productRegister(ModelMap model) {
    List<ProductCategory> categories = adminProductRegisterService.productCategoryList(0l);
    Product product = new Product();
    model.addAttribute("categories", categories);
    model.addAttribute("product", product);
    return "admin/product/product_register";
  }

  // 중소분류 읽어오기.
  @ResponseBody
  @GetMapping("/product_detail/register/lowcategories/{parentId}")
  public List<ProductCategory> getLowLevelCategories(@PathVariable("parentId") Long parentId) {
    List<ProductCategory> categories = adminProductRegisterService.productCategoryList(parentId);
    System.out.println("===================  " + categories.size());
    return categories;
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
    System.out.println("================ description : " + description);

//    String description = productDto.getProductDescription();
//
//    Long parentId = productDto.getProductCategoryId();
//
//    System.out.println("상품명 : " + productDto.getName());
//    System.out.println("체크박스 :  " + productDto.getDisplay());
//
//    productDto.setManufactureDate(date1);
//    productDto.setReleaseDate(date2);
//    productDto.setRegDate(LocalDateTime.now());

    product.setManufactureDate(date1);
    product.setReleaseDate(date2);
    product.setRegDate(LocalDateTime.now());

//    Product product = adminProductRegisterService.productDtoToProduct(productDto);
//
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
      ModelMap modelMpa,
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

  @GetMapping({"/product_search", "/product_search/{pageStart}"})
  public String productSearch(ModelMap modelMap, @PathVariable Optional<Integer> pageStart) {

    // 대분류를 불러온다
    List<ProductCategory> largeCategories = adminProductRegisterService.productCategoryList(0L);
    modelMap.addAttribute("largeCategories", largeCategories);

    // 모든 상품 리스트를 불러온다(페이지)
    Pageable pageable = PageRequest.of(pageStart.isPresent() ? pageStart.get() - 1 : 0, 10);
    Page<Product> allProductList = adminProductRegisterService.getAllProducts(pageable);

    int productPageCount = allProductList.getTotalPages();
    modelMap.addAttribute("productPageCount", productPageCount);
    modelMap.addAttribute("allProductList", allProductList);

    return "admin/product/product_search";
  }

  @PostMapping("/product_search")
  public String productSearchPost(ModelMap modelMap,
      @RequestParam("productSearchClassification") String productSearchClassificationValue,
      @RequestParam("productSearchClassificationInput") String productSearchClassificationInput,
      @RequestParam("productLargeCategoryId") Long largeId,
      @RequestParam("productMiddleCategoryId") Long middleId,
      @RequestParam("productSmallCategoryId") Long smallId,
      @RequestParam("productSearchDate") String productSearchDateValue,
      //TODO: null 값으로 들어왔을 경우 페이지 에러가 나지 않는 방안 모색
      @RequestParam(value = "regdateStart", defaultValue = "0000-00-00 00:00") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String productStartDateSelect,
      @RequestParam(value = "regdateEnd", defaultValue = "0000-00-00 00:00") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") String productEndDateSelect) {
//    @RequestParam("productSearchDateInput") @DateTimeFormat(pattern="yyyy/MM/dd") Date productSearchDateInput) {
//    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date1,
//    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date2,

    log.info("productSearchClassificationValue: " + productSearchClassificationValue);
    log.info("productSearchClassificationInput: " + productSearchClassificationInput);
    log.info("largeId: " + largeId);
    log.info("middleId: " + middleId);
    log.info("smallId: " + smallId);
    log.info("productSearchDateValue: " + productSearchDateValue);
//    log.info("productSearchDateInput: " + productSearchDateInput);

    // 모든 상품 리스트를 불러온다(페이지)
    // TODO: 검색 결과도 페이징 처리 필요
    // TODO: QueryDSL 추후 적용
    Pageable pageable = PageRequest.of(0, 10);
    Page<Product> allProductList = adminProductRegisterService.getAllProducts(pageable);

    int productPageCount = allProductList.getTotalPages();
    modelMap.addAttribute("productPageCount", productPageCount);
    modelMap.addAttribute("allProductList", allProductList);

    LocalDateTime castDateStart = LocalDateTime.parse(productStartDateSelect);
    LocalDateTime castDateEnd = LocalDateTime.parse(productEndDateSelect);

    //제품 등록일or게시일로 검색하기
    Page<Product> productDatepages = productService
        .findByProductRegdate(castDateStart, castDateEnd, pageable);
    modelMap.addAttribute("regdate", productDatepages);

    return "admin/product/product_search";
  }

//  @GetMapping("/product_detail/option/modify")
//  public String modifyOption(ProductOption productOption, Model model){
//    String modification = "으아아아";
//    //modelMap.addAttribute("productOptionMod", productOption);
//    //model.addAttribute("modification", modification);
//
//    log.info("옵션수정버튼을 눌렀습니다.");
//    log.info("modification : " + modification);
//
//    return "admin/product/product_detail";
//  }

//  @GetMapping("/product_detail/option/modify")
//  public String modifyOption(){
//
//    log.info("옵션수정버튼을 눌렀습니다.");
//
//    return "redirect:/admin/product/product_detail";
//  }





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
    System.out.println("================== productId : " + productId);
    System.out.println(
        "=======================product_option_list : " + productOptionCommand.getProductOptions()
            .size());
    System.out.println(
        "============= proudctOptionCommand.name" + productOptionCommand.getProductOptions().get(0)
            .getName());

    List<ProductOption> productOptions = adminProductOptionService
        .fromProductOptionCommandToProductOptionList(productOptionCommand);
    adminProductOptionService.save(productOptions, productId);

//    productOption.setProduct(productService.getProduct(productId));
//    productOptionService.addProductOption(productOption);

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
